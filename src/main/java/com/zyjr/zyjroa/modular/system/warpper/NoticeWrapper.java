package com.zyjr.zyjroa.modular.system.warpper;

import java.util.Map;

import com.zyjr.zyjroa.common.constant.factory.ConstantFactory;
import com.zyjr.zyjroa.core.base.warpper.BaseControllerWarpper;

/**
 * 部门列表的包装
 *
 * @author fengshuonan
 * @date 2017年4月25日 18:10:31
 */
public class NoticeWrapper extends BaseControllerWarpper {

    public NoticeWrapper(Object list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
        Integer creater = (Integer) map.get("creater");
        map.put("createrName", ConstantFactory.me().getUserNameById(creater));
    }

}
