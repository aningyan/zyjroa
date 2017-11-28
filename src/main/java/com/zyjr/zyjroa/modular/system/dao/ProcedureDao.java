package com.zyjr.zyjroa.modular.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 流程dao
 *
 * @author yj
 * @date 2017年11月17日20:28:58
 */
public interface ProcedureDao {

    /**
     * 获取符合条件的审批流程
     *
     * @return
     * @date 2017年11月17日 下午8:28:43
     */
    List<Map<String,Object>> getProcedure(@Param("templateid")Integer templateid);
}
