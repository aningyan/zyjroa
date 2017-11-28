package com.zyjr.zyjroa.common.persistence.model;
import java.util.Date;


public class ProcedureHoliday{

	/**
	 *	
	 */
	private int procedureid;

	/**
	 *	模板id
	 */
	private int templateid;

	/**
	 *	流程名称
	 */
	private String procedureName;

	/**
	 *	最后编辑id
	 */
	private String reviseUserid;

	/**
	 *	创建时间
	 */
	private Date createTime;

	/**
	 *	更新时间
	 */
	private Date updateTime;

	/**
	 *	是否删除0-未删除1-已删除
	 */
	private int isdeleted;

	/**
	 *	所属部门
	 */
	private String depts;

	/**
	 *	请假天数值1
	 */
	private int dayFirstValue;

	/**
	 *	数值大小关系
	 */
	private int dayRelation;

	/**
	 *	数值2
	 */
	private int daySecondValue;

	public void setProcedureid(int procedureid){
		this.procedureid=procedureid;
	}

	public int getProcedureid(){
		return procedureid;
	}

	public void setTemplateid(int templateid){
		this.templateid=templateid;
	}

	public int getTemplateid(){
		return templateid;
	}

	public void setProcedureName(String procedureName){
		this.procedureName=procedureName;
	}

	public String getProcedureName(){
		return procedureName;
	}

	public void setReviseUserid(String reviseUserid){
		this.reviseUserid=reviseUserid;
	}

	public String getReviseUserid(){
		return reviseUserid;
	}

	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}

	public Date getCreateTime(){
		return createTime;
	}

	public void setUpdateTime(Date updateTime){
		this.updateTime=updateTime;
	}

	public Date getUpdateTime(){
		return updateTime;
	}

	public void setIsdeleted(int isdeleted){
		this.isdeleted=isdeleted;
	}

	public int getIsdeleted(){
		return isdeleted;
	}

	public void setDepts(String depts){
		this.depts=depts;
	}

	public String getDepts(){
		return depts;
	}

	public void setDayFirstValue(int dayFirstValue){
		this.dayFirstValue=dayFirstValue;
	}

	public int getDayFirstValue(){
		return dayFirstValue;
	}

	public void setDayRelation(int dayRelation){
		this.dayRelation=dayRelation;
	}

	public int getDayRelation(){
		return dayRelation;
	}

	public void setDaySecondValue(int daySecondValue){
		this.daySecondValue=daySecondValue;
	}

	public int getDaySecondValue(){
		return daySecondValue;
	}

}

