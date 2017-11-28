package com.zyjr.zyjroa.common.persistence.model;


public class Holiday_type{

	/**
	 *	主键id
	 */
	private int id;

	/**
	 *	排序
	 */
	private int xorder;

	/**
	 *	请假类型
	 */
	private int title;

	/**
	 *	说明
	 */
	private String remark;

	public void setId(int id){
		this.id=id;
	}

	public int getId(){
		return id;
	}

	public void setXorder(int xorder){
		this.xorder=xorder;
	}

	public int getXorder(){
		return xorder;
	}

	public void setTitle(int title){
		this.title=title;
	}

	public int getTitle(){
		return title;
	}

	public void setRemark(String remark){
		this.remark=remark;
	}

	public String getRemark(){
		return remark;
	}

}

