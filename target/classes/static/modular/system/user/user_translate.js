/**
 * 用户详情对话框（可用于添加和修改对话框）
 */
var UserInfoDlg = {
    userInfoData: {},
};

/**
 * 清除数据
 */
UserInfoDlg.clearData = function () {
    this.userInfoData = {};
};

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
UserInfoDlg.set = function (key, val) {
    this.userInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
};

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
UserInfoDlg.get = function (key) {
    return $("#" + key).val();
};

/**
 * 关闭此对话框
 */
UserInfoDlg.close = function () {
    parent.layer.close(window.parent.MgrUser.layerIndex);
};



/**
 * 收集数据
 */
UserInfoDlg.collectData = function () {
    this.set('id').set('translateDate').set('leaveDate')};


/**
 * 提交转正修改
 */
UserInfoDlg.submit= function () {
    this.clearData();
    this.collectData();
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/mgr/translate", function (data) {
        Feng.success("修改成功!");
        if (window.parent.MgrUser != undefined) {
            window.parent.MgrUser.table.refresh();
            UserInfoDlg.close();
        }
    }, function (data) {
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    //ajax.set(this.userInfoData);
    ajax.set("usertype", 3);//3为正式员工  
    ajax.set("date", this.userInfoData.translateDate);//转正日期  
    ajax.set("userid", this.userInfoData.id);  
    ajax.start();
    
};



/**
 * 提交离职修改
 */
UserInfoDlg.leaveSubmit= function () {
    this.clearData();
    this.collectData();
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/mgr/translate", function (data) {
        Feng.success("修改成功!");
        if (window.parent.MgrUser != undefined) {
            window.parent.MgrUser.table.refresh();
            UserInfoDlg.close();
        }
    }, function (data) {
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    //ajax.set(this.userInfoData);
    ajax.set("usertype", 4);//4为离职  
    ajax.set("date", this.userInfoData.leaveDate);//转正日期  
    ajax.set("userid", this.userInfoData.id);  
    ajax.start();
    
};

$(function () {
    Feng.initValidator("translateForm", UserInfoDlg.validateFields);
});
