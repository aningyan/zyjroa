package com.zyjr.zyjroa.common.persistence.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author yanjia
 * @since 2017-11-9
 */
public class Dept extends Model<Dept> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 排序
     */
	private Integer num;
    /**
     * 父部门id
     */
	private Integer pid;
    /**
     * 父级ids
     */
	private String pids;
    /**
     * 简称
     */
	private String simplename;
    /**
     * 全称
     */
	private String fullname;
    /**
     * 版本（乐观锁保留字段）
     */
	private Integer version;
    /**
     * 部门代码按照一定规则自动生成
     */
	private String depcode;
    /**
     * 部门所属公司数据来源于公司信息表
     */
	private Integer comid;
    /**
     * 级别
     */
	private Integer depgrade;
    /**
     * 是否有变更记录
     */
	private Integer ischange;
    /**
     * 部门成本中心，数据来源于成本中心配置表
     */
	private Integer depcost;
    /**
     * 部门负责人，数据来源于人员信息表且在职的员工
     */
	private Integer director;
    /**
     * 部门创建日期
     */
	private String effectdate;
    /**
     * 是否失效
     */
	private Integer isdisable;
    /**
     * 失效日期
     */
	private Date disableddate;
    /**
     * 备注
     */
	private String remark;
    /**
     * 登记人
     */
	private Integer regby;
    /**
     * 登记日期
     */
	private Date regdate;
	 /**
     * 是否确认
     */
	private Integer initialized;
	
	 /**
     * 确认人
     */
	private Integer initializedby;
	
	 /**
     * 确认日期
     */
	private Date initializedtime;
	
	 /**
     * 是否封存
     */
	private Integer closed;
	
	 /**
     * 封存人
     */
	private Integer closedby;
	
	 /**
     * 封存日期
     */
	private Date closedtime;
	
	
	


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPids() {
		return pids;
	}

	public void setPids(String pids) {
		this.pids = pids;
	}

	public String getSimplename() {
		return simplename;
	}

	public void setSimplename(String simplename) {
		this.simplename = simplename;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getDepcode() {
		return depcode;
	}

	public void setDepcode(String depcode) {
		this.depcode = depcode;
	}

	public Integer getComid() {
		return comid;
	}

	public void setComid(Integer comid) {
		this.comid = comid;
	}

	public Integer getDepgrade() {
		return depgrade;
	}


	public Integer getIschange() {
		return ischange;
	}

	public void setIschange(Integer ischange) {
		this.ischange = ischange;
	}

	public void setDepgrade(Integer depgrade) {
		this.depgrade = depgrade;
	}

	public Integer getDepcost() {
		return depcost;
	}

	public void setDepcost(Integer depcost) {
		this.depcost = depcost;
	}

	public Integer getDirector() {
		return director;
	}

	public void setDirector(Integer director) {
		this.director = director;
	}

	public String getEffectdate() {
		return effectdate;
	}

	public void setEffectdate(String effectdate) {
		this.effectdate = effectdate;
	}

	public Integer getIsdisable() {
		return isdisable;
	}

	public void setIsdisable(Integer isdisable) {
		this.isdisable = isdisable;
	}

	public Date getDisableddate() {
		return disableddate;
	}

	public void setDisableddate(Date disableddate) {
		this.disableddate = disableddate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getRegby() {
		return regby;
	}

	public void setRegby(Integer regby) {
		this.regby = regby;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Integer getInitialized() {
		return initialized;
	}

	public void setInitialized(Integer initialized) {
		this.initialized = initialized;
	}

	public Integer getInitializedby() {
		return initializedby;
	}

	public void setInitializedby(Integer initializedby) {
		this.initializedby = initializedby;
	}

	public Date getInitializedtime() {
		return initializedtime;
	}

	public void setInitializedtime(Date initializedtime) {
		this.initializedtime = initializedtime;
	}

	public Integer getClosed() {
		return closed;
	}

	public void setClosed(Integer closed) {
		this.closed = closed;
	}

	public Integer getClosedby() {
		return closedby;
	}

	public void setClosedby(Integer closedby) {
		this.closedby = closedby;
	}

	public Date getClosedtime() {
		return closedtime;
	}

	public void setClosedtime(Date closedtime) {
		this.closedtime = closedtime;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
	

	@Override
	public String toString() {
		return "Dept{" +
			"id=" + id +
			", num=" + num +
			", pid=" + pid +
			", pids=" + pids +
			", simplename=" + simplename +
			", fullname=" + fullname +
			", version=" + version +
			"}";
	}
}
