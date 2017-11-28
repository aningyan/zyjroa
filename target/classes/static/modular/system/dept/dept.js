/**
 * 部门管理初始化
 */
var Dept = {
    id: "DeptTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1,
    comid:0
};

/**
 * 初始化表格的列
 */
Dept.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: '部门代码', field: 'depcode', align: 'center', valign: 'middle',width:'80px'},
        {title: '部门简称', field: 'simplename', align: 'center', valign: 'middle', sortable: true},
        {title: '部门全称', field: 'fullname', align: 'center', valign: 'middle', sortable: true},
        {title: '部门负责人', field: 'directorName', align: 'center', valign: 'middle', sortable: true},
        {title: '是否确认', field: 'initializedText', align: 'center', valign: 'middle', sortable: true},
        {title: '是否失效', field: 'isdisableText', align: 'center', valign: 'middle', sortable: true},
        {title: '是否封存', field: 'closedText', align: 'center', valign: 'middle', sortable: true}];
};

/**
 * 检查是否选中
 */
Dept.check = function () {
    var selected = $('#' + this.id).bootstrapTreeTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Dept.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加部门
 */
Dept.openAddDept = function () {
    var index = layer.open({
        type: 2,
        title: '添加部门',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/dept/dept_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看部门详情
 */
Dept.openDeptDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '部门详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/dept/dept_update/' + Dept.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除部门
 */
Dept.delete = function () {
    if (this.check()) {

        var operation = function(){
            var ajax = new $ax(Feng.ctxPath + "/dept/delete", function () {
                Feng.success("删除成功!");
                Dept.table.refresh();
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("deptId",Dept.seItem.id);
            ajax.start();
        };

        Feng.confirm("是否刪除该部门?", operation);
    }
};

/**
 * 确认部门
 */
Dept.affirmDept = function () {
    if (this.check()) {

        var operation = function(){
            var ajax = new $ax(Feng.ctxPath + "/dept/affirmDept", function () {
                Feng.success("确认成功!");
                Dept.table.refresh();
            }, function (data) {
                Feng.error("确认失败!" + data.responseJSON.message + "!");
            });
            ajax.set("deptId",Dept.seItem.id);
            ajax.start();
        };

        Feng.confirm("是否确认?", operation);
    }
};

/**
 * 失效部门
 */
Dept.loseDept = function () {
    if (this.check()) {

        var operation = function(){
            var ajax = new $ax(Feng.ctxPath + "/dept/loseDept", function () {
                Feng.success("失效成功!");
                Dept.table.refresh();
            }, function (data) {
                Feng.error("失效失败!" + data.responseJSON.message + "!");
            });
            ajax.set("deptId",Dept.seItem.id);
            ajax.start();
        };

        Feng.confirm("是否失效该部门?", operation);
    }
};

/**
 * 封存部门
 */
Dept.closeDept = function () {
    if (this.check()) {

        var operation = function(){
            var ajax = new $ax(Feng.ctxPath + "/dept/closeDept", function () {
                Feng.success("封存成功!");
                Dept.table.refresh();
            }, function (data) {
                Feng.error("封存失败!" + data.responseJSON.message + "!");
            });
            ajax.set("deptId",Dept.seItem.id);
            ajax.start();
        };

        Feng.confirm("是否封存该部门?", operation);
    }
};

/**
 * 查询部门列表
 */
Dept.search = function () {
    var queryData = {};
    queryData['comid'] = Dept.comid;
    queryData['condition'] = $("#condition").val();
    Dept.table.refresh({query: queryData});
};

/**
 * 部门详情
 */
Dept.detail = function () {
	 if (this.check()) {
	        var index = layer.open({
	            type: 2,
	            title: '部门详情',
	            area: ['800px', '420px'], //宽高
	            fix: false, //不固定
	            maxmin: true,
	            content: Feng.ctxPath + '/dept/todetailPage/' + Dept.seItem.id
	        });
	        this.layerIndex = index;
	    }
};
Dept.onClickCompany = function (e, treeId, treeNode) {
	Dept.comid = treeNode.id;
	Dept.search();
};

$(function () {
    var defaultColunms = Dept.initColumn();
    var table = new BSTreeTable(Dept.id, "/dept/list", defaultColunms);
    table.setExpandColumn(2);
    table.setIdField("id");
    table.setCodeField("id");
    table.setParentCodeField("pid");
    table.setExpandAll(true);
    table.init();
    Dept.table = table;
});

$(function () {
	var defaultColunms = Dept.initColumn();
	var ztree = new $ZTree("companyTree", "/company/tree");
	ztree.bindOnClick(Dept.onClickCompany);
	ztree.init();
});


