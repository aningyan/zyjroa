package com.zyjr.zyjroa.modular.system.dao;

import org.apache.ibatis.annotations.Param;

import com.zyjr.zyjroa.core.node.ZTreeNode;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 部门dao
 *
 * @author yj
 * @date 2017年11月17日20:28:58
 */
public interface DeptDao {

    /**
     * 获取ztree的节点列表
     *
     * @return
     * @date 2017年11月17日 下午8:28:43
     */
    List<ZTreeNode> tree();

    List<Map<String, Object>> list(@Param("condition") String condition, @Param("comid")Integer comid);

	void closeDept(@Param("deptId")Integer deptId, @Param("userid")Integer userid,  @Param("time")Date time);

	void affirmDept(@Param("deptId")Integer deptId, @Param("userid")Integer userid, @Param("time")Date time);

	void loseDept(@Param("deptId")Integer deptId,  @Param("time")Date time);

}
