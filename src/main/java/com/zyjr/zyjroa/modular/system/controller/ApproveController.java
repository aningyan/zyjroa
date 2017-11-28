package com.zyjr.zyjroa.modular.system.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.zyjr.zyjroa.common.persistence.dao.ApproveMapper;
import com.zyjr.zyjroa.common.persistence.dao.ProcedureHolidayMapper;
import com.zyjr.zyjroa.common.persistence.dao.TemplateMapper;
import com.zyjr.zyjroa.common.persistence.model.Approve;
import com.zyjr.zyjroa.core.base.controller.BaseController;
import com.zyjr.zyjroa.core.shiro.ShiroKit;
import com.zyjr.zyjroa.modular.system.service.IProcedureService;

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
    IProcedureService procedureService;


    /**
     * 跳转到公司管理首页
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
     * 我的审批列表
     */
    @RequestMapping("/myApprove")
    @ResponseBody
    public Object myApprove() {
          return this.templateMapper.selectList(null);
    	
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
    	approve.setApproveStatus(0);//状态为待审批
    	approve.setApproveStatusText("待审批");//审批状态文本
    	approveMapper.insert(approve);
    	//根据查到的流程插入该审批对应的审批人
    	if(approvers != null) {
    		for (Map<String, Object> approver : approvers) {
				A
				

			}
    	}
    	return super.SUCCESS_TIP;	

    }

    /**
     * 审批
     */
    @RequestMapping("/doApprove")
    @ResponseBody
    public Object doApprove(Integer templateid,Integer approveid) {
    	//查找流程
    	//更改审批记录表状态
    	//更改审批人表状态
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
          return this.templateMapper.selectList(null);
    	
    }

    
}
