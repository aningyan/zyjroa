package com.zyjr.zyjroa.common.persistence.model;
import java.util.Date;


public class Approver{

	/**
	 *	
	 */
	private int approverid;

	/**
	 *	
	 */
	private int approveid;

	/**
	 *	
	 */
	private int userid;

	/**
	 *	
	 */
	private int approverLevel;

	/**
	 *	
	 */
	private int status;

	/**
	 *	
	 */
	private String statusText;

	/**
	 *	
	 */
	private String isapproval;

	/**
	 *	
	 */
	private String isparent;

	/**
	 *	
	 */
	private int isoperator;

	/**
	 *	
	 */
	private int isreade;

	/**
	 *	
	 */
	private Date approvalTime;

	/**
	 *	
	 */
	private String approvalRemark;

	/**
	 *	
	 */
	private Date createTime;

	public void setApproverid(int approverid){
		this.approverid=approverid;
	}

	public int getApproverid(){
		return approverid;
	}

	public void setApproveid(int approveid){
		this.approveid=approveid;
	}

	public int getApproveid(){
		return approveid;
	}

	public void setUserid(int userid){
		this.userid=userid;
	}

	public int getUserid(){
		return userid;
	}

	public void setApproverLevel(int approverLevel){
		this.approverLevel=approverLevel;
	}

	public int getApproverLevel(){
		return approverLevel;
	}

	public void setStatus(int status){
		this.status=status;
	}

	public int getStatus(){
		return status;
	}

	public void setStatusText(String statusText){
		this.statusText=statusText;
	}

	public String getStatusText(){
		return statusText;
	}

	public void setIsapproval(String isapproval){
		this.isapproval=isapproval;
	}

	public String getIsapproval(){
		return isapproval;
	}

	public void setIsparent(String isparent){
		this.isparent=isparent;
	}

	public String getIsparent(){
		return isparent;
	}

	public void setIsoperator(int isoperator){
		this.isoperator=isoperator;
	}

	public int getIsoperator(){
		return isoperator;
	}

	public void setIsreade(int isreade){
		this.isreade=isreade;
	}

	public int getIsreade(){
		return isreade;
	}

	public void setApprovalTime(Date approvalTime){
		this.approvalTime=approvalTime;
	}

	public Date getApprovalTime(){
		return approvalTime;
	}

	public void setApprovalRemark(String approvalRemark){
		this.approvalRemark=approvalRemark;
	}

	public String getApprovalRemark(){
		return approvalRemark;
	}

	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}

	public Date getCreateTime(){
		return createTime;
	}

}

