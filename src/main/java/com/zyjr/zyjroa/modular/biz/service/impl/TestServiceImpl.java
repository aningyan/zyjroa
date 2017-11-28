package com.zyjr.zyjroa.modular.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zyjr.zyjroa.common.constant.DSEnum;
import com.zyjr.zyjroa.common.persistence.dao.TestMapper;
import com.zyjr.zyjroa.common.persistence.model.Test;
import com.zyjr.zyjroa.core.mutidatasource.annotion.DataSource;
import com.zyjr.zyjroa.modular.biz.service.ITestService;

/**
 * 测试服务
 *
 * @author fengshuonan
 * @date 2017-06-23 23:02
 */
@Service
public class TestServiceImpl implements ITestService {


    @Autowired
    TestMapper testMapper;

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public void testBiz() {
        Test test = testMapper.selectById(1);
        test.setId(22);
        test.insert();
    }


    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_GUNS)
    public void testGuns() {
        Test test = testMapper.selectById(1);
        test.setId(33);
        test.insert();
    }

    @Override
    @Transactional
    public void testAll() {
        testBiz();
        testGuns();
        //int i = 1 / 0;
    }

}