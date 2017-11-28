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
    this.set('id').set('registerType').set('registerAddress').set('contactAddress').set('emergencyPerson')
        .set('emergencyMobile').set('emergencyRelation').set('birthday').set('emergencyAddress').set('graduateSchool').set('major')
        .set('education').set('degree').set('professional').set('contractFirstPaty').set('firstpartyRemark')
        .set('contractStartDate').set('probation').set('contractEndDate').set('salaryAccountUnit').set('bankAccount')
        .set('bank').set('insuranceUnit').set('insuranceRemark').set('accumulationUnit').set('accumulationRamark')
        .set('insuranceAddress').set('accumulationAddress').set('workAddress').set('userSource').set('workExpress');
};


/**
 * 提交修改
 */
UserInfoDlg.completeSubmit= function () {

    this.clearData();
    this.collectData();


    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/mgr/completeInfo", function (data) {
        Feng.success("修改成功!");
        if (window.parent.MgrUser != undefined) {
            window.parent.MgrUser.table.refresh();
            UserInfoDlg.close();
        }
    }, function (data) {
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.userInfoData);
    ajax.start();
};

function onBodyDown(event) {
    if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(
            event.target).parents("#menuContent").length > 0)) {
        UserInfoDlg.hideDeptSelectTree();
    }
}

$(function () {
    Feng.initValidator("userTotalForm", UserInfoDlg.validateFields);

    // 初始化头像上传
    var avatarUp = new $WebUpload("avatar");
    avatarUp.setUploadBarId("progressBar");
    avatarUp.init();


});
