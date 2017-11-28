package com.zyjr.zyjroa.modular.system.factory;

import org.springframework.beans.BeanUtils;

import com.zyjr.zyjroa.common.persistence.model.User;
import com.zyjr.zyjroa.modular.system.transfer.UserDto;
import com.zyjr.zyjroa.modular.system.transfer.UserTotalInfo;

/**
 * 用户创建工厂
 *
 * @author fengshuonan
 * @date 2017-05-05 22:43
 */
public class UserFactory {

    public static User createUser(UserDto userDto){
        if(userDto == null){
            return null;
        }else{
            User user = new User();
            BeanUtils.copyProperties(userDto,user);
            return user;
        }
    }
    
    /**
     * 包含职位信息的完成人员信息
     * @param userDto
     * @return
     */
    public static User createTotalUser(UserTotalInfo userDto){
        if(userDto == null){
            return null;
        }else{
            User user = new User();
            BeanUtils.copyProperties(userDto,user);
            return user;
        }
    }
}
