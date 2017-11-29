package com.zyjr.zyjroa.modular.system.transfer;
/**
 * 审批时传输累
 * @author yanjia
 *
 */
public class ApproveDto {
	private Integer approveid;
	private Integer approveStatus;
	private String remark;
	public Integer getApproveid() {
		return approveid;
	}
	public void setApproveid(Integer approveid) {
		this.approveid = approveid;
	}
	public Integer getApproveStatus() {
		return approveStatus;
	}
	public void setApproveStatus(Integer approveStatus) {
		this.approveStatus = approveStatus;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
