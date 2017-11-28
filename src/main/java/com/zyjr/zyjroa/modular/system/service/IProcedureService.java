package com.zyjr.zyjroa.modular.system.service;

import java.util.List;
import java.util.Map;

/**
 * 流程服务
 *
 * @author yj
 * @date 2017-11-13
 */
public interface IProcedureService {

	 /**
     * 获取符合条件的审批流程
	 * @param loginDept 
	 * @param days 
	 * @param templateid 
     *
     * @return
     * @date 2017年11月17日 下午8:28:43
     */
    List<Map<String,Object>> getProcedure(Integer templateid, Integer days, Integer loginDept);

}
