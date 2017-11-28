package com.zyjr.zyjroa.modular.system.service;

import java.util.Date;

/**
 * 部门服务
 *
 * @author yj
 * @date 2017-11-13
 */
public interface IDeptService {

    /**
     * 删除部门
     *
     * @author yj
     * @Date 2017-11-13
     */
   void deleteDept(Integer deptId);
   /**
    * 封存部门
    * @param deptId
    */
	void closeDept(Integer deptId,Integer userid,Date time);
	/**
	 * 确认部门
	 * @param deptId
	 * @param userid
	 * @param time
	 */
	void affirmDept(Integer deptId, Integer userid, Date time);
	/**
	 * 失效部门
	 * @param deptId
	 * @param date
	 */
	void loseDept(Integer deptId, Date date);

}
