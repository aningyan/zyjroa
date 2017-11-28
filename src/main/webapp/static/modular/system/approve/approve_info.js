/**
 * 初始化部门详情对话框
 */
var ApproveDlg = {
    deptInfoData : {},
    zTreeInstance : null,
    validateFields: {
        simplename: {
            validators: {
                notEmpty: {
                    message: '部门名称不能为空'
                }
            }
        },
        fullname: {
            validators: {
                notEmpty: {
                    message: '部门全称不能为空'
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
ApproveDlg.clearData = function() {
    this.deptInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ApproveDlg.set = function(key, val) {
    this.deptInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ApproveDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ApproveDlg.close = function() {
    parent.layer.close(window.parent.Dept.layerIndex);
}

/**
 * 点击部门ztree列表的选项时
 *
 * @param e
 * @param treeId
 * @param treeNode
 * @returns
 */
ApproveDlg.onClickDept = function(e, treeId, treeNode) {
    $("#pName").attr("value", ApproveDlg.zTreeInstance.getSelectedVal());
    $("#pid").attr("value", treeNode.id);
}

/**
 * 显示部门选择的树
 *
 * @returns
 */
ApproveDlg.showDeptSelectTree = function() {
    var pName = $("#pName");
    var pNameOffset = $("#pName").offset();
    $("#parentDeptMenu").css({
        left : pNameOffset.left + "px",
        top : pNameOffset.top + pName.outerHeight() + "px"
    }).slideDown("fast");

    $("body").bind("mousedown", onBodyDown);
}

/**
 * 隐藏部门选择的树
 */
ApproveDlg.hideDeptSelectTree = function() {
    $("#parentDeptMenu").fadeOut("fast");
    $("body").unbind("mousedown", onBodyDown);// mousedown当鼠标按下就可以触发，不用弹起
}

/**
 * 收集数据
 */
ApproveDlg.collectData = function() {
    this.set('id').set('simplename').set('fullname').set('remark').set('num').set('pid').set('comid').set('director')
    .set('depcost').set('depgrade').set('effectdate');
}

/**
 * 验证数据是否为空
 */
ApproveDlg.validate = function () {
    $('#deptInfoForm').data("bootstrapValidator").resetForm();
    $('#deptInfoForm').bootstrapValidator('validate');
    return $("#deptInfoForm").data('bootstrapValidator').isValid();
}

function onBodyDown(event) {
    if (!(event.target.id == "menuBtn" || event.target.id == "parentDeptMenu" || $(
            event.target).parents("#parentDeptMenu").length > 0)) {
        ApproveDlg.hideDeptSelectTree();
    }
}


function copySelect(id, index) {
	var oSelect = document.createElement("select");
	oSelect.className="my_class";
	oSelect.id = 'approver'+(id++);
/*	oSelect.options.add(new Option('直属上级', ++index));
	oSelect.options.add(new Option('部门经理', ++index));
	oSelect.options.add(new Option('人事经理', ++index));*/
	oSelect.options.add(new Option('直属领导', 1));
	oSelect.options.add(new Option('部门负责人', 2));
	oSelect.options.add(new Option('人力资源审核', 3));
	oSelect.options.add(new Option('分管副总审核', 4));
	oSelect.options.add(new Option('总裁审批', 5));
	return {
		select: oSelect,
		lastIndex: oSelect.options.length,
		lastId: id
	};
}

ApproveDlg.addAprrove  = function() {
	var divInfo = document.getElementById("procedureInfo");
	var oSelect = copySelect(divInfo.lastId || 1, divInfo.lastIndex || 0);
	divInfo.appendChild(oSelect.select);
	divInfo.__proto__['lastIndex'] = oSelect.lastIndex || 0;
	divInfo.__proto__['lastId'] = oSelect.lastId;
}


$(function () {
    $('#myTab a:last').tab('show');
  })
  $('#myTab a').click(function (e) {
  e.preventDefault();
  $(this).tab('show');
})

$(function() {
    Feng.initValidator("deptInfoForm", ApproveDlg.validateFields);

    var ztree = new $ZTree("parentDeptMenuTree", "/dept/tree");
    ztree.bindOnClick(ApproveDlg.onClickDept);
    ztree.init();
    ApproveDlg.zTreeInstance = ztree;
});

laydate.render({
	  		elem: '.demo-input'
		  ,type: 'datetime'
	});


