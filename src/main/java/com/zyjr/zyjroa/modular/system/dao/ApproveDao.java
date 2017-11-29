package com.zyjr.zyjroa.modular.system.dao;

import java.util.List;
import java.util.Map;

import com.zyjr.zyjroa.common.persistence.model.Approve;

/**
 * 审批相关的dao
 *
 * @author yj
 * @date 2017年11.29
 */
public interface ApproveDao {
/**
 * 审批人有我的审批
 */
	List<Approve> getMyApprove(Integer userid);

	Map<String,Object> approveDetail(Integer approveid);


}
