package com.zyjr.zyjroa.common.persistence.model;
import java.util.Date;


public class ProcedureApprover{

	/**
	 *	主键
	 */
	private int id;

	/**
	 *	流程id
	 */
	private int procedureid;

	/**
	 *	审批人
	 */
	private int userid;

	/**
	 *	审批级别
	 */
	private String approverLevel;

	/**
	 *	是否是经办人
	 */
	private int isoperator;

	/**
	 *	创建时间
	 */
	private Date createTime;

	/**
	 *	更新时间
	 */
	private Date updateTime;

	/**
	 *	是否删除
	 */
	private int isdeleted;

	public void setId(int id){
		this.id=id;
	}

	public int getId(){
		return id;
	}

	public void setProcedureid(int procedureid){
		this.procedureid=procedureid;
	}

	public int getProcedureid(){
		return procedureid;
	}

	public void setUserid(int userid){
		this.userid=userid;
	}

	public int getUserid(){
		return userid;
	}

	public void setApproverLevel(String approverLevel){
		this.approverLevel=approverLevel;
	}

	public String getApproverLevel(){
		return approverLevel;
	}

	public void setIsoperator(int isoperator){
		this.isoperator=isoperator;
	}

	public int getIsoperator(){
		return isoperator;
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

}

