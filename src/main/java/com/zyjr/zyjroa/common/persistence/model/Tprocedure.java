package com.zyjr.zyjroa.common.persistence.model;


public class Tprocedure{

	/**
	 *	流程id
	 */
	private int procedureid;

	/**
	 *	模板id
	 */
	private int templateid;

	/**
	 *	流程内容
	 */
	private String approveContent;

	/**
	 *	审批人
	 */
	private int approveRole;

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

	public void setApproveContent(String approveContent){
		this.approveContent=approveContent;
	}

	public String getApproveContent(){
		return approveContent;
	}

	public void setApproveRole(int approveRole){
		this.approveRole=approveRole;
	}

	public int getApproveRole(){
		return approveRole;
	}

}

