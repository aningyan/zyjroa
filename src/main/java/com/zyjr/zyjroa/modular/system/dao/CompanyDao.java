package com.zyjr.zyjroa.modular.system.dao;

import org.apache.ibatis.annotations.Param;

import com.zyjr.zyjroa.core.node.ZTreeNode;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 公司dao
 *
 * @author yj
 * @date 2017年11.11
 */
public interface CompanyDao {

    /**
     * 获取ztree的节点列表
     *
     * @return
     * @date 2017年2月17日 下午8:28:43
     */
    List<ZTreeNode> tree();

    List<Map<String, Object>> list(@Param("condition") String condition);
    
    void affirmCompany(@Param("comid")Integer comid, @Param("userid")Integer userid,  @Param("time")Date time);
	void loseCompany(@Param("comid")Integer comid,@Param("time")Date time);

	void closeCompany(@Param("comid")Integer comid, @Param("userid")Integer userid, @Param("time")Date time);

}
