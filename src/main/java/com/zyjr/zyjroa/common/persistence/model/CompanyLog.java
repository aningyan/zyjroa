package com.zyjr.zyjroa.common.persistence.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 公司表
 * </p>
 *
 * @author yanjia
 * @since 2017-11-9
 */
public class CompanyLog extends Model<CompanyLog> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 公司代码
     */
	private String compcode;
    /**
     * 父部门id
     */
	private Integer pid;
	
	  /**
     * 关联公司id
     */
	private Integer comid;
    /**
     * 父级ids
     */
	private String pids;
    /**
     * 简称
     */
	private String compabbr;
    /**
     * 全称
     */
	private String title;
    /**
     * 公司级别
     */
	private Integer compgrade;
    /**
     * 机构创建日期
     */
	private Date effectdate;
    /**
     * 公司法人
     */
	private Integer lawyer;
    /**
     * 地址
     */
	private String address;
    /**
     * 注册地
     */
	private String regaddress;
    /**
     * 电话
     */
	private String tel;
    /**
     * 传真
     */
	private String fax;
    /**
     * 部门负责人，数据来源于人员信息表且在职的员工
     */
	private Integer director;
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
     * 排序
     */
	private Integer xorder;
	  /**
     * 类型
     */
	private Integer type;
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

	public void setClosedtime(Date closedtime) {
		this.closedtime = closedtime;
	}

	public String getCompcode() {
		return compcode;
	}

	public void setCompcode(String compcode) {
		this.compcode = compcode;
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

	public String getCompabbr() {
		return compabbr;
	}

	public void setCompabbr(String compabbr) {
		this.compabbr = compabbr;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getCompgrade() {
		return compgrade;
	}

	public void setCompgrade(Integer compgrade) {
		this.compgrade = compgrade;
	}

	public Date getEffectdate() {
		return effectdate;
	}

	public void setEffectdate(Date effectdate) {
		this.effectdate = effectdate;
	}

	public Integer getLawyer() {
		return lawyer;
	}

	public void setLawyer(Integer lawyer) {
		this.lawyer = lawyer;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegaddress() {
		return regaddress;
	}

	public void setRegaddress(String regaddress) {
		this.regaddress = regaddress;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public Integer getDirector() {
		return director;
	}

	public void setDirector(Integer director) {
		this.director = director;
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

	public Integer getXorder() {
		return xorder;
	}

	public void setXorder(Integer xorder) {
		this.xorder = xorder;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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


	public Integer getComid() {
		return comid;
	}

	public void setComid(Integer comid) {
		this.comid = comid;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", compcode=" + compcode + ", pid=" + pid + ", pids=" + pids + ", compabbr="
				+ compabbr + ", title=" + title + ", compgrade=" + compgrade + ", effectdate=" + effectdate
				+ ", lawyer=" + lawyer + ", address=" + address + ", regaddress=" + regaddress + ", tel=" + tel
				+ ", fax=" + fax + ", director=" + director + ", isdisable=" + isdisable + ", disableddate="
				+ disableddate + ", remark=" + remark + ", xorder=" + xorder + ", type=" + type + ", regby=" + regby
				+ ", regdate=" + regdate + ", initialized=" + initialized + ", initializedby=" + initializedby
				+ ", initializedtime=" + initializedtime + ", closed=" + closed + ", closedby=" + closedby
				+ ", closedtime=" + closedtime + "]";
	}

	@Override
	protected Serializable pkVal() {
		return null;
	}


	
	

}
