/**
 * 表单
 */
var Approve = {
    id: "managerTable",//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1,
    deptid:0
};



/**
 * 初始化表格的列
 */
Approve.initColumn = function () {
    var columns = [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'templateid', visible: false, align: 'center', valign: 'middle'},
        {title: '表单名称', field: 'templateName', align: 'center', valign: 'middle', sortable: true},
        {title: '所属类型', field: 'templateType', align: 'center', valign: 'middle', sortable: true}];
    return columns;
};


/**
 * 检查是否选中
 */
Approve.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
    	Approve.seItem = selected[0];
        return true;
    }
};


/**
 * 配置流程
 */
Approve.addProcedure  = function() {
	 if (this.check()) {
	        var index = layer.open({
	            type: 2,
	            title: '配置流程',
	            area: ['800px', '450px'], //宽高
	            fix: false, //不固定
	            maxmin: true,
	            content: Feng.ctxPath + '/approve/add_procedure/' + this.seItem.templateid
	        });
	        this.layerIndex = index;
	    }
	
};
/**
 * 填写表单
 */
Approve.addApprove  = function() {
	 if (this.check()) {
	        var index = layer.open({
	            type: 2,
	            title: '表单填写',
	            area: ['800px', '450px'], //宽高
	            fix: false, //不固定
	            maxmin: true,
	            content: Feng.ctxPath + '/approve/add_approve/' + this.seItem.templateid
	        });
	        this.layerIndex = index;
	    }
	
};


Approve.search = function () {
    var queryData = {};

    queryData['deptid'] = Approve.deptid;
    queryData['name'] = $("#name").val();
    queryData['onOrLeave'] = $("#onOrLeave").val();
    queryData['beginTime'] = $("#beginTime").val();
    queryData['endTime'] = $("#endTime").val();

    Approve.table.refresh({query: queryData});
}

Approve.onClickDept = function (e, treeId, treeNode) {
    Approve.deptid = treeNode.id;
    Approve.search();
};


$(function () {
    var defaultColunms = Approve.initColumn();
    var table = new BSTable("managerTable", "/approve/templatelist", defaultColunms);
    table.setPaginationType("client");
    Approve.table = table.init();
    var ztree = new $ZTree("deptTree", "/dept/tree");
    ztree.bindOnClick(Approve.onClickDept);
    ztree.init();
});
