package com.zyjr.zyjroa.modular.system.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyjr.zyjroa.common.annotion.BussinessLog;
import com.zyjr.zyjroa.common.annotion.Permission;
import com.zyjr.zyjroa.common.constant.dictmap.DeptDict;
import com.zyjr.zyjroa.common.constant.factory.ConstantFactory;
import com.zyjr.zyjroa.common.exception.BizExceptionEnum;
import com.zyjr.zyjroa.common.exception.BussinessException;
import com.zyjr.zyjroa.common.persistence.dao.CompanyLevelMapper;
import com.zyjr.zyjroa.common.persistence.dao.CompanyLogMapper;
import com.zyjr.zyjroa.common.persistence.dao.CompanyMapper;
import com.zyjr.zyjroa.common.persistence.model.Company;
import com.zyjr.zyjroa.common.persistence.model.CompanyLevel;
import com.zyjr.zyjroa.common.persistence.model.CompanyLog;
import com.zyjr.zyjroa.common.persistence.model.Dept;
import com.zyjr.zyjroa.core.base.controller.BaseController;
import com.zyjr.zyjroa.core.log.LogObjectHolder;
import com.zyjr.zyjroa.core.node.ZTreeNode;
import com.zyjr.zyjroa.core.util.ToolUtil;
import com.zyjr.zyjroa.modular.system.dao.CompanyDao;
import com.zyjr.zyjroa.modular.system.service.ICompanyService;
import com.zyjr.zyjroa.modular.system.warpper.DeptWarpper;

/**
 * 公司控制器
 * @author yanjia
 *
 */
@Controller
@RequestMapping("/company")
public class CompanyController extends BaseController {

    private String PREFIX = "/system/company/";

    @Resource
    CompanyDao companyDao;

    @Resource
    CompanyMapper companyMapper;
    @Resource
    CompanyLevelMapper companyLevelMapper;
    
    @Resource
    CompanyLogMapper companyLogMapper;

    @Resource
    ICompanyService companyService;

    /**
     * 跳转到公司管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "company.html";
    }

    /**
     * 跳转到添加公司
     */
    @RequestMapping("/company_add")
    public String deptAdd() {
        return PREFIX + "company_add.html";
    }

    /**
     * 跳转到修改公司
     */
    @Permission
    @RequestMapping("/company_update/{comid}")
    public String deptUpdate(@PathVariable Integer comid, Model model) {
        Company company = companyMapper.selectById(comid);
        model.addAttribute(company);
        model.addAttribute("pName", ConstantFactory.me().getCompanyName(company.getPid()));
        model.addAttribute("lawyerName", ConstantFactory.me().getUserNameById(company.getLawyer()));
        LogObjectHolder.me().set(company);
        return PREFIX + "company_edit.html";
    }

    /**
     * 获取公司的tree列表
     */
    @RequestMapping(value = "/tree")
    @ResponseBody
    public List<ZTreeNode> tree() {
        List<ZTreeNode> tree = this.companyDao.tree();
        tree.add(ZTreeNode.createParent());
        return tree;
    }

    /**
     * 新增公司
     */
    @RequestMapping(value = "/add")
    @Permission
    @ResponseBody
    public Object add(Company company) {
        if (ToolUtil.isOneEmpty(company, company.getCompabbr())) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        //完善pids,根据pid拿到pid的pids
        companySetPids(company);
        company.setCompcode("c");//按规则生成公司编号
        company.setRegby(this.getUserId());//登记人
        company.setRegdate(new Date());//登记日期
        return this.companyMapper.insert(company);
    }

    /**
     * 获取所有公司列表
     */
    @RequestMapping(value = "/list")
    @Permission
    @ResponseBody
    public Object list(String condition) {
        List<Map<String, Object>> list = this.companyDao.list(condition);
        return super.warpObject(new DeptWarpper(list));
    }

    /**
     * 公司详情
     */
    @RequestMapping(value = "/detail/{comid}")
    @Permission
    @ResponseBody
    public Object detail(@PathVariable("comid") Integer comid) {
        return companyMapper.selectById(comid);
    }

    /**
     * 修改公司
     */
    @BussinessLog(value = "修改公司", key = "simplename", dict = DeptDict.class)
    @RequestMapping(value = "/update")
    @Permission
    @ResponseBody
    public Object update(Company company) {
        if (ToolUtil.isEmpty(company) || company.getComid() == null) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        companySetPids(company);
        company.setIschange(1);
        companyMapper.updateById(company);
        //修改公司的同时插入一张日志数据 保存其修改数据
        CompanyLog companyLog = new CompanyLog();
        BeanUtils.copyProperties(company,companyLog);
        companyLog.setType(4);//变更类型为编辑公司
        companyLogMapper.insert(companyLog);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除公司
     */
    @RequestMapping(value = "/delete")
    @Permission
    @ResponseBody
    public Object delete(@RequestParam Integer comid) {

        //缓存被删除的公司名称
        LogObjectHolder.me().set(ConstantFactory.me().getCompanyName(comid));

       // deptService.deleteDept(comid);

        return SUCCESS_TIP;
    }

    
    /**
     * 公司级别列表
     */
    @RequestMapping(value = "/getCompanyLevel")
    @ResponseBody
    public Object getCompanyLevel() {
        List<CompanyLevel> list = companyLevelMapper.selectList(null);
        return list;
    }


    /**
     * 封存公司
     */
    @RequestMapping(value = "/closeCompany")
    @Permission
    @ResponseBody
    public Object closeDept(@RequestParam Integer comid) {
        companyService.closeCompany(comid,this.getUserId(),new Date());
        //封存公司后 插入修改记录表
        CompanyLog companyLog = new CompanyLog();
        Company detail = (Company)detail(comid);
        companyLog.setClosed(1);
        companyLog.setClosedby(this.getUserId());
        companyLog.setClosedtime(new Date());
        BeanUtils.copyProperties(detail,companyLog);
        companyLog.setType(2);//变更类型为封存公司
        companyLogMapper.insert(companyLog);
        return SUCCESS_TIP;
    }
    
    
    /**
     * 确认公司
     */
    @RequestMapping(value = "/affirmCompany")
    @Permission
    @ResponseBody
    public Object affirmCompany(@RequestParam Integer comid) {

        companyService.affirmCompany(comid,this.getUserId(),new Date());
        //确认公司后 插入修改记录表
        CompanyLog companyLog = new CompanyLog();
        Company detail = (Company) detail(comid);
        companyLog.setInitialized(1);
        companyLog.setInitializedby(this.getUserId());
        companyLog.setInitializedtime(new Date());
        BeanUtils.copyProperties(detail,companyLog);
        companyLog.setType(1);//变更类型为确认公司
        companyLogMapper.insert(companyLog);
        return SUCCESS_TIP;
    }
    
    /**
     * 失效公司
     */
    @RequestMapping(value = "/loseCompany")
    @Permission
    @ResponseBody
    public Object loseCompany(@RequestParam Integer comid) {

        companyService.loseCompany(comid,new Date());
        //确认公司后 插入修改记录表
        CompanyLog companyLog = new CompanyLog();
        Company detail = (Company) detail(comid);
        companyLog.setIsdisable(1);
        companyLog.setDisableddate(new Date());
        BeanUtils.copyProperties(detail,companyLog);
        companyLog.setType(2);//变更类型为失效公司
        companyLogMapper.insert(companyLog);
        return SUCCESS_TIP;
    }

    
    /**
     *公司详情
     */
    @Permission
    @RequestMapping("/todetailPage/{comid}")
    public String todetailPage(@PathVariable Integer comid, Model model) {
        Company company = companyMapper.selectById(comid);
        model.addAttribute(company);
        //上级部门名称
        model.addAttribute("pName", ConstantFactory.me().getCompanyName(company.getPid()));
        //级别表同步部门级别
        model.addAttribute("levelText", ConstantFactory.me().getLevelText(company.getCompgrade()));
       //同步人员表中法人
        model.addAttribute("lawyer", ConstantFactory.me().getUserNameById(company.getLawyer()));
        //是否失效
        model.addAttribute("isdisable",company.getIsdisable()==0?"未失效":"已失效");
        //同步人员表中登记人
        model.addAttribute("regby",ConstantFactory.me().getUserNameById(company.getRegby()));
        //是否确认
        model.addAttribute("initialized",company.getInitialized()==0?"未确认":"已确认");
      //是否发生变更
        model.addAttribute("ischange",company.getIschange()==0?"未变更":"已变更");
        //同步人员表中确认人
        model.addAttribute("initializedby",ConstantFactory.me().getUserNameById(company.getInitializedby()));
        model.addAttribute("closed",company.getClosed()==0?"未封存":"已封存");
        //同步人员表中封存人
        model.addAttribute("closedby",ConstantFactory.me().getUserNameById(company.getClosedby()));
        LogObjectHolder.me().set(company);
        return PREFIX + "company_detail.html";
    }
    
    private void companySetPids(Company company) {
        if (ToolUtil.isEmpty(company.getPid()) || company.getPid().equals(0)) {
        	company.setPid(0);
        	company.setPids("[0],");
        } else {
            int pid = company.getPid();
            Company temp = companyMapper.selectById(pid);
            String pids = temp.getPids();
            company.setPid(pid);
            company.setPids(pids + "[" + pid + "],");
        }
    }
}
