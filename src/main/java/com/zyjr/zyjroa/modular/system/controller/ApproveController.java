package com.zyjr.zyjroa.modular.system.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.zyjr.zyjroa.common.annotion.Permission;
import com.zyjr.zyjroa.common.exception.BizExceptionEnum;
import com.zyjr.zyjroa.common.exception.BussinessException;
import com.zyjr.zyjroa.common.persistence.dao.HolidayMapper;
import com.zyjr.zyjroa.common.persistence.dao.ProcedureHolidayMapper;
import com.zyjr.zyjroa.common.persistence.dao.TemplateMapper;
import com.zyjr.zyjroa.common.persistence.model.Holiday;
import com.zyjr.zyjroa.common.persistence.model.ProcedureHoliday;
import com.zyjr.zyjroa.core.base.controller.BaseController;
import com.zyjr.zyjroa.core.shiro.ShiroKit;
import com.zyjr.zyjroa.core.util.ToolUtil;

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
    HolidayMapper holidayMapper;


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
    	model.addAttribute("loginUserName", ShiroKit.getUser().getName());
      	model.addAttribute("loginDeptName", ShiroKit.getUser().getDeptName());
      	model.addAttribute("loginCompanyName", ShiroKit.getUser().getCompanyName());
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
    @Permission
    @ResponseBody
    public Object add(ProcedureHoliday procedureHoliday) {
        if (ToolUtil.isOneEmpty(procedureHoliday, procedureHoliday.getProcedureName())) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        return this.procedureHolidayMapper.insert(procedureHoliday);
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
    	//查找流程
    	//确认当前审批人
    	//插入审批记录表
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
