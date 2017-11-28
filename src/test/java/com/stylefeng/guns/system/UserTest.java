package com.stylefeng.guns.system;

import com.stylefeng.guns.base.BaseJunit;
import com.zyjr.zyjroa.common.persistence.dao.UserMapper;
import com.zyjr.zyjroa.modular.system.dao.UserMgrDao;

import org.junit.Test;

import javax.annotation.Resource;

/**
 * 用户测试
 *
 * @author fengshuonan
 * @date 2017-04-27 17:05
 */
public class UserTest extends BaseJunit {

    @Resource
    UserMgrDao userMgrDao;

    @Resource
    UserMapper userMapper;

    @Test
    public void userTest() throws Exception {

    }

}
