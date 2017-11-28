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
import com.zyjr.zyjroa.common.persistence.dao.DeptLevelMapper;
import com.zyjr.zyjroa.common.persistence.dao.DeptLogMapper;
import com.zyjr.zyjroa.common.persistence.dao.DeptMapper;
import com.zyjr.zyjroa.common.persistence.model.Company;
import com.zyjr.zyjroa.common.persistence.model.CompanyLog;
import com.zyjr.zyjroa.common.persistence.model.Dept;
import com.zyjr.zyjroa.common.persistence.model.DeptLevel;
import com.zyjr.zyjroa.common.persistence.model.DeptLog;
import com.zyjr.zyjroa.core.base.controller.BaseController;
import com.zyjr.zyjroa.core.log.LogObjectHolder;
import com.zyjr.zyjroa.core.node.ZTreeNode;
import com.zyjr.zyjroa.core.util.ToolUtil;
import com.zyjr.zyjroa.modular.system.dao.DeptDao;
import com.zyjr.zyjroa.modular.system.service.IDeptService;
import com.zyjr.zyjroa.modular.system.warpper.DeptWarpper;

/**
 * 部门控制器
 * @author yanjia
 *
 */
@Controller
@RequestMapping("/dept")
public class DeptController extends BaseController {

    private String PREFIX = "/system/dept/";

    @Resource
    DeptDao deptDao;

    @Resource
    DeptMapper deptMapper;
    

    @Resource
    DeptLevelMapper deptLevelMapper;
    
    @Resource
    DeptLogMapper deptLogMapper;

    @Resource
    IDeptService deptService;

    /**
     * 跳转到部门管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "dept.html";
    }

    /**
     * 跳转到添加部门
     */
    @RequestMapping("/dept_add")
    public String deptAdd() {
        return PREFIX + "dept_add.html";
    }

    /**
     * 跳转到修改部门
     */
    @Permission
    @RequestMapping("/dept_update/{deptId}")
    public String deptUpdate(@PathVariable Integer deptId, Model model) {
        Dept dept = deptMapper.selectById(deptId);
        model.addAttribute(dept);
        //所属公司名称
        model.addAttribute("companyName", ConstantFactory.me().getCompanyName(dept.getComid()));
        //级别表同步部门级别
        model.addAttribute("levelText", ConstantFactory.me().getLevelText(dept.getDepgrade()));
        //同步成本中心
        //model.addAttribute("depcost", ConstantFactory.me().getLevelText(dept.getDepgrade()));
        model.addAttribute("directorName", ConstantFactory.me().getUserNameById(dept.getDirector()));
        model.addAttribute("pName", ConstantFactory.me().getDeptName(dept.getPid()));
        LogObjectHolder.me().set(dept);
        return PREFIX + "dept_edit.html";
    }

    /**
     * 获取部门的tree列表
     */
    @RequestMapping(value = "/tree")
    @ResponseBody
    public List<ZTreeNode> tree() {
        List<ZTreeNode> tree = this.deptDao.tree();
        tree.add(ZTreeNode.createParent());
        return tree;
    }

    /**
     * 新增部门
     */
    @BussinessLog(value = "添加部门", key = "simplename", dict = DeptDict.class)
    @RequestMapping(value = "/add")
    @Permission
    @ResponseBody
    public Object add(Dept dept) {
        if (ToolUtil.isOneEmpty(dept, dept.getSimplename())) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        //完善pids,根据pid拿到pid的pids
        deptSetPids(dept);
        dept.setDepcode("d");//按规则生成部门编号
        dept.setRegby(this.getUserId());//登记人
        dept.setRegdate(new Date());//登记日期
        return this.deptMapper.insert(dept);
    }

    /**
     *部门详情
     */
    @Permission
    @RequestMapping("/todetailPage/{deptId}")
    public String todetailPage(@PathVariable Integer deptId, Model model) {
        Dept dept = deptMapper.selectById(deptId);
        model.addAttribute(dept);
        //所属公司名称
        model.addAttribute("companyName", ConstantFactory.me().getCompanyName(dept.getComid()));
        //上级部门名称
        model.addAttribute("pName", ConstantFactory.me().getDeptName(dept.getPid()));
        //级别表同步部门级别
        model.addAttribute("levelText", ConstantFactory.me().getLevelText(dept.getDepgrade()));
        //同步成本中心
        //model.addAttribute("depcost", ConstantFactory.me().getLevelText(dept.getDepgrade()));
       //同步人员表中部门负责人
        model.addAttribute("directorName", ConstantFactory.me().getUserNameById(dept.getDirector()));
        //是否失效
        model.addAttribute("isdisable",dept.getIsdisable()==0?"已失效":"未失效");
        //同步人员表中登记人
        model.addAttribute("regby",ConstantFactory.me().getUserNameById(dept.getRegby()));
        //是否确认
        model.addAttribute("initialized",dept.getInitialized()==0?"未确认":"已确认");
        //同步人员表中确认人
        model.addAttribute("initializedby",ConstantFactory.me().getUserNameById(dept.getInitializedby()));
        model.addAttribute("closed",dept.getClosed()==0?"未封存":"已封存");
        //同步人员表中封存人
        model.addAttribute("closedby",ConstantFactory.me().getUserNameById(dept.getClosedby()));

        LogObjectHolder.me().set(dept);
        return PREFIX + "dept_detail.html";
    }
    
    /**
     * 获取所有部门列表
     */
    @RequestMapping(value = "/list")
    @Permission
    @ResponseBody
    public Object list(@RequestParam(required = false)String condition,@RequestParam(required = false) Integer comid) {
        List<Map<String, Object>> list = this.deptDao.list(condition,comid);
        return super.warpObject(new DeptWarpper(list));
    }

    /**
     * 部门详情
     */
    @RequestMapping(value = "/detail/{deptId}")
    @Permission
    @ResponseBody
    public Object detail(@PathVariable("deptId") Integer deptId) {
    	return deptMapper.selectById(deptId);
    }

    /**
     * 修改部门
     */
    @BussinessLog(value = "修改部门", key = "simplename", dict = DeptDict.class)
    @RequestMapping(value = "/update")
    @Permission
    @ResponseBody
    public Object update(Dept dept) {
        if (ToolUtil.isEmpty(dept) || dept.getId() == null) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        deptSetPids(dept);
        deptMapper.updateById(dept);
        
        DeptLog deptLog = new DeptLog();
        BeanUtils.copyProperties(dept,deptLog);
        //修改时存放备份到修改记录中
        deptLogMapper.insert(deptLog);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除部门
     */
    @BussinessLog(value = "删除部门", key = "deptId", dict = DeptDict.class)
    @RequestMapping(value = "/delete")
    @Permission
    @ResponseBody
    public Object delete(@RequestParam Integer deptId) {

        //缓存被删除的部门名称
        LogObjectHolder.me().set(ConstantFactory.me().getDeptName(deptId));

        deptService.deleteDept(deptId);

        return SUCCESS_TIP;
    }
    

    /**
     * 封存部门
     */
    @BussinessLog(value = "/封存部门", key = "deptId", dict = DeptDict.class)
    @RequestMapping(value = "/closeDept")
    @Permission
    @ResponseBody
    public Object closeDept(@RequestParam Integer deptId) {

        deptService.closeDept(deptId,this.getUserId(),new Date());
        //封存部门后 插入修改记录表
        DeptLog deptLog = new DeptLog();
        Dept detail = (Dept) detail(deptId);
        deptLog.setInitialized(1);
        deptLog.setInitializedby(this.getUserId());
        deptLog.setInitializedtime(new Date());
        BeanUtils.copyProperties(detail,deptLog);
        deptLogMapper.insert(deptLog);
        return SUCCESS_TIP;
    }
    
    
    /**
     * 确认部门
     */
    @BussinessLog(value = "/确认部门", key = "deptId", dict = DeptDict.class)
    @RequestMapping(value = "/affirmDept")
    @Permission
    @ResponseBody
    public Object affirmDept(@RequestParam Integer deptId) {

        deptService.affirmDept(deptId,this.getUserId(),new Date());
        //确认部门后 插入修改记录表
        DeptLog deptLog = new DeptLog();
        Dept detail = (Dept) detail(deptId);
        deptLog.setInitialized(1);
        deptLog.setInitializedby(this.getUserId());
        deptLog.setInitializedtime(new Date());
        BeanUtils.copyProperties(detail,deptLog);
        deptLogMapper.insert(deptLog);
        return SUCCESS_TIP;
    }
    
    /**
     * 失效部门
     */
    @RequestMapping(value = "/loseDept")
    @Permission
    @ResponseBody
    public Object loseCompany(@RequestParam Integer deptId) {

    	deptService.loseDept(deptId,new Date());
        //确认公司后 插入修改记录表
        DeptLog deptLog = new DeptLog();
        Dept detail = (Dept) detail(deptId);
        deptLog.setIsdisable(1);
        deptLog.setDisableddate(new Date());
        BeanUtils.copyProperties(detail,deptLog);
        deptLog.setType(2);//变更类型为失效部门
        deptLogMapper.insert(deptLog);
        return SUCCESS_TIP;
    }
    
    /**
     * 部门级别列表
     */
    @RequestMapping(value = "/getDeptLevel")
    @ResponseBody
    public Object getDeptLevel() {
        List<DeptLevel> list = deptLevelMapper.selectList(null);
        return list;
    }

    private void deptSetPids(Dept dept) {
        if (ToolUtil.isEmpty(dept.getPid()) || dept.getPid().equals(0)) {
            dept.setPid(0);
            dept.setPids("[0],");
        } else {
            int pid = dept.getPid();
            Dept temp = deptMapper.selectById(pid);
            String pids = temp.getPids();
            dept.setPid(pid);
            dept.setPids(pids + "[" + pid + "],");
        }
    }
}
