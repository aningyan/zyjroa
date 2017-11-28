package com.zyjr.zyjroa.modular.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.zyjr.zyjroa.modular.system.dao.ProcedureApproverDao;
import com.zyjr.zyjroa.modular.system.dao.ProcedureDao;
import com.zyjr.zyjroa.modular.system.service.IProcedureService;

@Service
@Transactional
public class ProcedureServiceImpl implements IProcedureService {
	
	@Resource
	ProcedureDao procedureDao;
	
	@Resource
	ProcedureApproverDao procedureApproveDao;
	@Override
	public List<Map<String, Object>> getProcedure(Integer templateid, Integer days, Integer loginDept) {
		List<Map<String, Object>> list = procedureDao.getProcedure(templateid);
		//获取流程id 如果有重复的流程配置 取第一个
		Integer procedureid = 0;
		switch(templateid) {
    	case 1:              
    		procedureid = getHolidayProcedure(list, days, loginDept);
    	}
		//查找审批人
		List<Map<String, Object>> approvers = procedureApproveDao.getProcedureApprover(procedureid);
		return approvers;
		
	}
	/**
	 * 
	 */
	private Integer getHolidayProcedure(List<Map<String, Object>> list,Integer days, Integer loginDept) {
		List<Map<String, Object>> newList = new ArrayList<Map<String, Object>>();
		Integer procedureid = 0;
		for (Map<String, Object>  map: list) {
			Map<String, Object> content = (Map<String, Object>) JSONObject.parse((String) map.get("approve_content"));
			if(content!= null){
				Integer dayType = ((Integer)content.get("dayType"));
				Integer firstvalue = ((Integer)content.get("firstValue"));
				Integer secondValue = ((Integer)content.get("secondValue"));
				if(judgeBig(dayType, days, firstvalue, secondValue)&&loginDept==((Integer)content.get("deptid"))) {
					//满足天数和部门
					newList.add(map);
					procedureid=(Integer) map.get("procedureid");
					return procedureid;
				}
			}
		}
		return procedureid;
		
	}
	/**
	 * 判断数字条件
	 * @return
	 */
	private Boolean judgeBig(Integer dayType,Integer days,Integer firstvalue,Integer secondValue) {
		switch(dayType) {
    	case 1:   //a> 数值
            return days> firstvalue;
		case 2:    //a>=数值         
            return days>= firstvalue;
		case 3:  //a<数值            
            return days< firstvalue;
		case 4:   //a<=数值              
            return days<= firstvalue;
		case 5:    //数值1<a<数字2         
            return  (firstvalue<days)&&(days<secondValue);
		case 6:    //数值1<=a<数值2          
            return (firstvalue<=days)&&(days<secondValue);
		case 7:     //数值1<=a<=数值2 
            return (firstvalue<=days)&&(days<=secondValue);
		case 8:     //数字1<a<=2        
            return (firstvalue<days)&&(days<=secondValue);
		default:
			return false;
    	}
	}

}
