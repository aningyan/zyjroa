package com.zyjr.zyjroa.common.persistence.model;


public class Holiday{

	/**
	 *	主键id
	 */
	private int id;

	/**
	 *	员工id
	 */
	private int userid;

	/**
	 *	请假类型
	 */
	private int type;

	/**
	 *	开始时间
	 */
	private String beginTime;

	/**
	 *	结束时间
	 */
	private String endTime;

	/**
	 *	单位 天/小时
	 */
	private long unit;

	/**
	 *	长度
	 */
	private long amount;

	/**
	 *	请假说明
	 */
	private String remark;

	public void setId(int id){
		this.id=id;
	}

	public int getId(){
		return id;
	}

	public void setUserid(int userid){
		this.userid=userid;
	}

	public int getUserid(){
		return userid;
	}

	public void setType(int type){
		this.type=type;
	}

	public int getType(){
		return type;
	}

	public void setBeginTime(String beginTime){
		this.beginTime=beginTime;
	}

	public String getBeginTime(){
		return beginTime;
	}

	public void setEndTime(String endTime){
		this.endTime=endTime;
	}

	public String getEndTime(){
		return endTime;
	}

	public void setUnit(long unit){
		this.unit=unit;
	}

	public long getUnit(){
		return unit;
	}

	public void setAmount(long amount){
		this.amount=amount;
	}

	public long getAmount(){
		return amount;
	}

	public void setRemark(String remark){
		this.remark=remark;
	}

	public String getRemark(){
		return remark;
	}

}

