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
@RequestMapping("/myApprove")
public class MyApproveController extends BaseController {

    private String PREFIX = "/system/myApprove/";

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
        return PREFIX + "myApprove.html";
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
