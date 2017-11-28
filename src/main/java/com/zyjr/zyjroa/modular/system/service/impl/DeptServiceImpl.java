package com.zyjr.zyjroa.modular.system.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.zyjr.zyjroa.common.persistence.dao.DeptMapper;
import com.zyjr.zyjroa.common.persistence.model.Dept;
import com.zyjr.zyjroa.modular.system.dao.DeptDao;
import com.zyjr.zyjroa.modular.system.service.IDeptService;

@Service
@Transactional
public class DeptServiceImpl implements IDeptService {

    @Resource
    DeptMapper deptMapper;
    @Resource
    DeptDao deptDao;

    @Override
    public void deleteDept(Integer deptId) {

        Dept dept = deptMapper.selectById(deptId);

        Wrapper<Dept> wrapper = new EntityWrapper<>();
        wrapper = wrapper.like("pids", "%[" + dept.getId() + "]%");
        List<Dept> subDepts = deptMapper.selectList(wrapper);
        for (Dept temp : subDepts) {
            temp.deleteById();
        }

        dept.deleteById();
    }

	@Override
	public void closeDept(Integer deptId,Integer userid,Date time) {
		deptDao.closeDept(deptId,userid,time);
	}
	
	@Override
	public void affirmDept(Integer deptId,Integer userid,Date time) {
		deptDao.affirmDept(deptId,userid,time);
	}

	@Override
	public void loseDept(Integer deptId, Date time) {
		deptDao.loseDept(deptId,time);
		
	}
}
