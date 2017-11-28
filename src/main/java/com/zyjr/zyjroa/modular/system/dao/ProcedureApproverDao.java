package com.zyjr.zyjroa.modular.system.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 通知dao
 *
 * @author fengshuonan
 * @date 2017-05-09 23:03
 */
public interface ProcedureApproverDao {

    List<Map<String, Object>> getProcedureApprover(@Param("procedureid") Integer procedureid);
}
