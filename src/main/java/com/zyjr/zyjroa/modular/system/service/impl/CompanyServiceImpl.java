package com.zyjr.zyjroa.modular.system.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.zyjr.zyjroa.common.persistence.dao.CompanyMapper;
import com.zyjr.zyjroa.common.persistence.model.Company;
import com.zyjr.zyjroa.modular.system.dao.CompanyDao;
import com.zyjr.zyjroa.modular.system.service.ICompanyService;

@Service
@Transactional
public class CompanyServiceImpl implements ICompanyService {

    @Resource
    CompanyMapper companyMapper;
    @Resource
    CompanyDao companyDao;

    @Override
    public void deleteCompany(Integer comid) {

    	Company company = companyMapper.selectById(comid);

        Wrapper<Company> wrapper = new EntityWrapper<>();
        wrapper = wrapper.like("pids", "%[" + company.getComid() + "]%");
        List<Company> subDepts = companyMapper.selectList(wrapper);
        for (Company temp : subDepts) {
            temp.deleteById();
        }

        company.deleteById();
    }

	@Override
	public void loseCompany(Integer comid, Date time) {
		companyDao.loseCompany(comid,time);
	}

	@Override
	public void closeCompany(Integer comid, Integer userid, Date time) {
		companyDao.closeCompany(comid,userid,time);
	}

	@Override
	public void affirmCompany(Integer comid, Integer userid, Date time) {
		companyDao.affirmCompany(comid,userid,time);
		
	}
    
}
