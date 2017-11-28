package com.zyjr.zyjroa.common.persistence.model;
import java.util.Date;


public class Approve{

	/**
	 *	申请审批id
	 */
	private int approveid;

	/**
	 *	申请审批编号
	 */
	private int approveNumber;

	/**
	 *	模板id
	 */
	private int templateid;

	/**
	 *	流程id
	 */
	private int procedureid;

	/**
	 *	申请员工id
	 */
	private int applyUserid;

	/**
	 *	申请内容
	 */
	private String approveContent;

	/**
	 *	审批状态(0-等待审批，1-审批中，2-审批通过，3-审批不通过，4-已撤销,6-已归档，7-已作废)
	 */
	private int approveStatus;

	/**
	 *	审批状态文本
	 */
	private String approveStatusText;

	/**
	 *	当前审批人
	 */
	private String currentApprover;

	/**
	 *	是否上传
	 */
	private int isupload;

	/**
	 *	创建时间
	 */
	private Date createTime;

	/**
	 *	更新时间
	 */
	private Date updateTime;

	/**
	 *	删除状态 1-已删除
	 */
	private int isdeleted;

	/**
	 *	作废理由
	 */
	private String deleteReason;

	public void setApproveid(int approveid){
		this.approveid=approveid;
	}

	public int getApproveid(){
		return approveid;
	}

	public void setApproveNumber(int approveNumber){
		this.approveNumber=approveNumber;
	}

	public int getApproveNumber(){
		return approveNumber;
	}

	public void setTemplateid(int templateid){
		this.templateid=templateid;
	}

	public int getTemplateid(){
		return templateid;
	}

	public void setProcedureid(int procedureid){
		this.procedureid=procedureid;
	}

	public int getProcedureid(){
		return procedureid;
	}

	public void setApplyUserid(int applyUserid){
		this.applyUserid=applyUserid;
	}

	public int getApplyUserid(){
		return applyUserid;
	}

	public void setApproveContent(String approveContent){
		this.approveContent=approveContent;
	}

	public String getApproveContent(){
		return approveContent;
	}

	public void setApproveStatus(int approveStatus){
		this.approveStatus=approveStatus;
	}

	public int getApproveStatus(){
		return approveStatus;
	}

	public void setApproveStatusText(String approveStatusText){
		this.approveStatusText=approveStatusText;
	}

	public String getApproveStatusText(){
		return approveStatusText;
	}

	public void setCurrentApprover(String currentApprover){
		this.currentApprover=currentApprover;
	}

	public String getCurrentApprover(){
		return currentApprover;
	}

	public void setIsupload(int isupload){
		this.isupload=isupload;
	}

	public int getIsupload(){
		return isupload;
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

	public void setDeleteReason(String deleteReason){
		this.deleteReason=deleteReason;
	}

	public String getDeleteReason(){
		return deleteReason;
	}

}

