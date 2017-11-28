package com.zyjr.zyjroa.common.persistence.model;


public class Template{

	/**
	 *	主键id
	 */
	private int templateid;

	/**
	 *	模板名称
	 */
	private String templateName;

	/**
	 *	模板类型
	 */
	private String templateType;

	/**
	 *	排序
	 */
	private int xorder;

	/**
	 *	备注
	 */
	private String remark;

	public void setTemplateid(int templateid){
		this.templateid=templateid;
	}

	public int getTemplateid(){
		return templateid;
	}

	public void setTemplateName(String templateName){
		this.templateName=templateName;
	}

	public String getTemplateName(){
		return templateName;
	}

	public void setTemplateType(String templateType){
		this.templateType=templateType;
	}

	public String getTemplateType(){
		return templateType;
	}

	public void setXorder(int xorder){
		this.xorder=xorder;
	}

	public int getXorder(){
		return xorder;
	}

	public void setRemark(String remark){
		this.remark=remark;
	}

	public String getRemark(){
		return remark;
	}

}

