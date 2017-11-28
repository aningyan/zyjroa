/**
 * 初始化公司详情对话框
 */
var CompanyInfoDlg = {
    companyInfoData : {},
    zTreeInstance : null,
    validateFields: {
    	compabbr: {
            validators: {
                notEmpty: {
                    message: '公司简称不能为空'
                }
            }
        },
        title: {
            validators: {
                notEmpty: {
                    message: '公司全称不能为空'
                }
            }
        },
        pName: {
            validators: {
                notEmpty: {
                    message: '上级名称不能为空'
                }
            }
        }
    }
};

/**
 * 清除数据
 */
CompanyInfoDlg.clearData = function() {
    this.companyInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CompanyInfoDlg.set = function(key, val) {
    this.companyInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CompanyInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
CompanyInfoDlg.close = function() {
    parent.layer.close(window.parent.Company.layerIndex);
}

/**
 * 点击部门ztree列表的选项时
 *
 * @param e
 * @param treeId
 * @param treeNode
 * @returns
 */
CompanyInfoDlg.onClickCompany = function(e, treeId, treeNode) {
    $("#pName").attr("value", CompanyInfoDlg.zTreeInstance.getSelectedVal());
    $("#pid").attr("value", treeNode.id);
}


/**
 * 显示部门选择的树
 *
 * @returns
 */
CompanyInfoDlg.showCompanySelectTree = function() {
    var pName = $("#pName");
    var pNameOffset = $("#pName").offset();
    $("#parentCompanyMenu").css({
        left : pNameOffset.left + "px",
        top : pNameOffset.top + pName.outerHeight() + "px"
    }).slideDown("fast");

    $("body").bind("mousedown", onBodyDown);
}

/**
 * 隐藏部门选择的树
 */
CompanyInfoDlg.hideCompanySelectTree = function() {
    $("#parentCompanyMenu").fadeOut("fast");
    $("body").unbind("mousedown", onBodyDown);// mousedown当鼠标按下就可以触发，不用弹起
}


/**
 * 收集数据
 */
CompanyInfoDlg.collectData = function() {
    this.set('comid').set('compabbr').set('compcode').set('pid').set('title').set('address').set('regaddress')
    .set('effectdate').set('tel').set('fax').set('remark').set('xorder').set('compgrade').set('lawyer');
}

/**
 * 验证数据是否为空
 */
CompanyInfoDlg.validate = function () {
    $('#companyInfoForm').data("bootstrapValidator").resetForm();
    $('#companyInfoForm').bootstrapValidator('validate');
    return $("#companyInfoForm").data('bootstrapValidator').isValid();
}

/**
 * 提交添加部门
 */
CompanyInfoDlg.addSubmit = function() {
    this.clearData();
    this.collectData();

    if (!this.validate()) {
        return;
    }

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/company/add", function(data){
        Feng.success("添加成功!");
        window.parent.Company.table.refresh();
        CompanyInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.companyInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
CompanyInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    if (!this.validate()) {
        return;
    }

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/company/update", function(data){
        Feng.success("修改成功!");
        window.parent.Company.table.refresh();
        CompanyInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.companyInfoData);
    ajax.start();
}

function onBodyDown(event) {
    if (!(event.target.id == "menuBtn" || event.target.id == "parentCompanyMenu" || $(
            event.target).parents("#parentCompanyMenu").length > 0)) {
        CompanyInfoDlg.hideCompanySelectTree();
    }
}


$(function() {
    Feng.initValidator("companyInfoForm", CompanyInfoDlg.validateFields);

    var ztree = new $ZTree("parentCompanyMenuTree", "/company/tree");
    ztree.bindOnClick(CompanyInfoDlg.onClickCompany);
    ztree.init();
    CompanyInfoDlg.zTreeInstance = ztree;
});



$(function () {
    $(".datepicker").datepicker({
        language: "zh-CN",
        autoclose: true,//选中之后自动隐藏日期选择框
        clearBtn: true,//清除按钮
        todayBtn: true,//今日按钮
        format: "yyyy-mm-dd"//日期格式，详见 http://bootstrap-datepicker.readthedocs.org/en/release/options.html#format
    });
});


$.ajax({
	                type: 'GET',
	                url: '/company/getCompanyLevel',
	                data: {
	                    id: 1
	                },
	                success: function(data) {
	                    var oSelect = $('#compgrade');
	                    for(var i = 0; i < data.length; i++){
	                        var d = data[i];
	                        oSelect.append('<option value="'+(d.id)+'">'+(d.leveltext)+'</option>');
	                    }
	                }
	            });


$.ajax({
	                type: 'POST',
	                url: '/mgr/selectList',
	                data: {
	                    id: 1
	                },
	                success: function(data) {
	                    var oSelect = $('#lawyer');
	                    for(var i = 0; i < data.length; i++){
	                        var d = data[i];
	                        oSelect.append('<option value="'+(d.id)+'">'+(d.name)+'</option>');
	                    }
	                }
	            });
