package com.zyjr.zyjroa.modular.system.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.zyjr.zyjroa.common.persistence.dao.ApproveMapper;
import com.zyjr.zyjroa.common.persistence.dao.ApproverMapper;
import com.zyjr.zyjroa.common.persistence.dao.DeptMapper;
import com.zyjr.zyjroa.common.persistence.dao.ProcedureHolidayMapper;
import com.zyjr.zyjroa.common.persistence.dao.TemplateMapper;
import com.zyjr.zyjroa.common.persistence.model.Approve;
import com.zyjr.zyjroa.common.persistence.model.Approver;
import com.zyjr.zyjroa.core.base.controller.BaseController;
import com.zyjr.zyjroa.core.shiro.ShiroKit;
import com.zyjr.zyjroa.modular.system.dao.ApproveDao;
import com.zyjr.zyjroa.modular.system.service.IProcedureService;
import com.zyjr.zyjroa.modular.system.transfer.ApproveDto;

/**
 * 申请控制器
 * @author yanjia
 *
 */
@Controller
@RequestMapping("/approve")
public class ApproveController extends BaseController {

    private String PREFIX = "/system/approve/";

    @Resource
    ProcedureHolidayMapper procedureHolidayMapper;
    
    @Resource
    TemplateMapper templateMapper;
    
    @Resource
    ApproveMapper approveMapper;
    
    @Resource
    ApproverMapper approverMapper;
    
    
    @Resource
    IProcedureService procedureService;
    
    @Resource
    DeptMapper deptMapper;
    
    @Resource
    ApproveDao approveDao;
    


    /**
     * 跳转到申请表单首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "approve.html";
    }

    /**
     * 跳转到添加流程页
     * 根据id判断跳转到哪个流程配置页
     */
    @RequestMapping("/add_procedure/{templateid}")
    public String addProcedure(@PathVariable Integer templateid,Model model) {
    	model.addAttribute("temid", templateid);
    	switch(templateid) {
    	case 1:              
            return PREFIX + "procedure_holiday_add.html";
    	}
		return "没有该模板流程配置页面";
    	
    }
    
    /**
     * 跳转到添加表单填写页
     * 根据id判断跳转到哪个表单填写页面
     */
    @RequestMapping("/add_approve/{templateid}")
    public String addApprove(@PathVariable Integer templateid,Model model) {
    	model.addAttribute("loginUserName", ShiroKit.getUser().getName());
      	model.addAttribute("loginDeptName", ShiroKit.getUser().getDeptName());
      	model.addAttribute("loginJob", ShiroKit.getUser().getJob());
    	switch(templateid) {
    	case 1:              
            return PREFIX + "approve_holiday_add.html";
    	}
		return "没有该页面";
    	
    }
    
    /**
     * 新增请假单流程
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(String content) {
    	String dataJson = "{\r\n" + 
    			"    \"temid\": 1,\r\n" + 
    			"    \"temName\": \"病假\",\r\n" + 
    			"    \"days\": 2\r\n" + 
    			"}";
    	//查找流程
    		Map<String,Object> map = (Map<String, Object>) JSONObject.parse(dataJson);
    	Integer loginDept =  ShiroKit.getUser().getDeptId();
    	Integer days = (Integer) map.get("days");
    	//查找起审批流程中的审批角色
    	List<Map<String, Object>> approvers =procedureService.getProcedure((Integer)map.get("temid"),days,loginDept);
    	//插入审批记录表
    	
    	return super.SUCCESS_TIP;	
    }
    

    
    /**
     * 提交审批
     * dataJason 为表单数据 各个表单不一样
     */
    @RequestMapping("/commitApprove")
    @ResponseBody
    public Object commitApprove(Integer templateid,String dataJson) {
    	dataJson = "{\r\n" + 
    			"    \"temid\": 1,\r\n" + 
    			"    \"temName\": \"病假\",\r\n" + 
    			"    \"days\": 2,\r\n" + 
    			"    \"isNonProfit\":\r\n" + 
    			"}";
    	//查找流程
    		Map<String,Object> map = (Map<String, Object>) JSONObject.parse(dataJson);
    	Integer loginDept =  ShiroKit.getUser().getDeptId();
    	Integer days = (Integer) map.get("days");
    	List<Map<String,Object>> approvers = procedureService.getProcedure(templateid,days,loginDept);
    	//插入审批记录表
    	Approve approve = new Approve();
    	approve.setApplyUserid(ShiroKit.getUser().getId());
    	approve.setApproveContent(dataJson);
    	approve.setApproveNumber(1);//后续需要生成规则
    	approve.setApproveStatus(1);//状态为审批中
    	approve.setApproveStatusText("审批中");//审批状态文本
    	approveMapper.insert(approve);
    	//根据查到的流程插入该审批对应的审批人
    	if(approvers != null) {
    		for (Map<String, Object> approver : approvers) {
				Approver apper = new Approver();
				//获取审批级别和审批角色
				Integer approveLevel = (Integer) approver.get("level");
				Integer roleid = (Integer) approver.get("roleid");
				//1-直属领导 2-部门负责人3-人力资源审核4-分管副总审核5-总裁审批
				apper.setApproverLevel(approveLevel);
				apper.setApproveid(approve.getApproveid());
				if(approveLevel==1) {
					//审批级别为1级 则设置状态为审批中
					apper.setStatus(1);
					apper.setStatusText("审批中");
				}else {
					//其他级别为待审批
					apper.setStatus(0);
					apper.setStatusText("待审批");
				}
				//审批流程中配置如果存在角色相同的审批人,则跳过重复审批人
	    		//1.申请人和审批人相同
				
				switch(roleid) {
		    	case 1:              
		            //查找当前提交人的直属上级
		    		Integer direct = ShiroKit.getUser().getDirect();
		    		apper.setApproverid(direct);
		    		break;
	    		case 2:              
	    			//查找当前提交人所在部门的部门负责人
	    			Integer deptid = ShiroKit.getUser().getDeptId();
	    			apper.setApproverid(deptMapper.selectById(deptid).getDirector());
		    		break;
		    	case 3:
		    		//查找人力资源经理(根据职位id?暂定)
		    		apper.setApproverid(1);
		    		break;
			    case 4:              
			        //暂定
			    	apper.setApproverid(1);
		    		break;
				case 5:              
					//暂定
					apper.setApproverid(1);
		    		break;
				}
				approverMapper.insert(apper);
			}
    	}
    	return super.SUCCESS_TIP;	

    }

    /**
     * 审批
     */
    @RequestMapping("/doApprove")
    @ResponseBody
    public Object doApprove(ApproveDto dto) {
    	//1.更新当前审批人状态
    	Approver app = new Approver();
    	app.setApproveid(dto.getApproveid());
    	app.setApproverid(ShiroKit.getUser().getId());
    	app.setApprovalRemark(dto.getRemark());
    	app.setStatus(dto.getApproveStatus());
    	if(dto.getApproveStatus()==2) {
    		//审批通过
    		app.setStatusText("审批通过");
    	}else if(dto.getApproveStatus()==3) {
    		//审批不通过
    		app.setStatusText("审批不通过");
    	}    
    	approverMapper.updateById(app);
    	
    	
    	//2.更新下一级审批人状态(利用级别和审批id查询,.如果没有下一级审批人则审批状态结束)
    	Approver upLevel = approverMapper.selectOne(app);//查找上一级审批人的审批级别
    	Approver currentApp = new Approver();
    	currentApp.setApproveid(dto.getApproveid());
    	currentApp.setApproverLevel(upLevel.getApproverLevel()+1);
    	Approver currentLevel = approverMapper.selectOne(currentApp);
    	Approve approve = new Approve();
    	approve.setApproveid(dto.getApproveid());
    	if(currentLevel!=null) {
    		//如果为空  说明这次审批为最后一级 整体审批已结束
    		currentApp.setApproveid(dto.getApproveid());
    		currentApp.setStatus(1);//设置待审批为审批中
    		currentApp.setStatusText("审批中");
        	approverMapper.updateById(currentApp);
        	approve.setCurrentApprover(currentLevel.getApproverid());//设置当前审批人
    	}else {
    		//3.更新审批数据
    		//更改审批记录表状态(审批通过or拒绝)
    		approve.setApproveStatus(dto.getApproveStatus());
    		if(dto.getApproveStatus()==2) {
    			//审批通过
    			approve.setApproveStatusText("审批通过");
    		}else if(dto.getApproveStatus()==3) {
    			//审批不通过
    			approve.setApproveStatusText("审批不通过");
    		}
    	}
    	approveMapper.updateById(approve);
    	
    	return super.SUCCESS_TIP;

    }

    
    /**
     * 表单列表
     */
    @RequestMapping("/templatelist")
    @ResponseBody
    public Object templatelist() {
          return this.templateMapper.selectList(null);
    	
    }


    
    /**
     * 我提交的申请
     */
    @RequestMapping("/myCommit")
    @ResponseBody
    public Object myCommit() {
          return approveMapper.selectPage(new RowBounds(1,20), 
     			 new EntityWrapper<Approve>().eq("applyUserid", ShiroKit.getUser().getId()));
    	
    }
    
    
    /**
     * 我审批的表单
     */
    @RequestMapping("/myApprove")
    @ResponseBody
    public Object myApprove() {
          return approveDao.getMyApprove(ShiroKit.getUser().getId());
    }
    
    
    /**
     * 审批表单详情
     */
    @RequestMapping("/approveDetail")
    @ResponseBody
    public Object approveDetail(Integer approveid) {
    	Map<String,Object> detail = approveDao.approveDetail(approveid);
    	Integer detailApproveid =0;
    	Integer templateid =0;
    	if(detail!=null) {
    		detailApproveid = (Integer) detail.get("approveid");
    		templateid= (Integer) detail.get("templateid");
    		//查找审批流程涉及的用户
    		List<Approver> approvers = approverMapper.selectList(new EntityWrapper<Approver>().eq("approveid", detailApproveid));
    		detail.put("approvers", approvers);
    	}
    	
    	//根据模板id返回不同页面
          return detail;
    }


    
}
