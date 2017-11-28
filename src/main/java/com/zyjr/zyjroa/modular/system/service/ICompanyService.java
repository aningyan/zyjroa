package com.zyjr.zyjroa.modular.system.service;

import java.util.Date;

/**
 * 部门服务
 *
 * @author yanjia
 * @date 2017.11.11
 */
public interface ICompanyService {

    /**
     * 删除部门
     *
     */
   void deleteCompany(Integer comid);
   
   /**
    * 失效部门
    *
    * @author yj
    * @Date 2017-11-13
    */
  void loseCompany(Integer comid,Date time);
  /**
   * 封存部门
   */
	void closeCompany(Integer comid,Integer userid,Date time);
	/**
	 * 确认公司
	 * @param userid
	 * @param time
	 */
	void affirmCompany(Integer comid, Integer userid, Date time);

}
