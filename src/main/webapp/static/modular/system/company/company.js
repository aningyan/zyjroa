/**
 * 公司管理初始化
 */
var Company = {
    id: "companyTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Company.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: '公司代码', field: 'comid', align: 'center', valign: 'middle',width:'80px'},
        {title: '公司代码', field: 'compcode', align: 'center', valign: 'middle',width:'80px'},
        {title: '公司简称', field: 'compabbr', align: 'center', valign: 'middle', sortable: true},
        {title: '公司全称', field: 'title', align: 'center', valign: 'middle', sortable: true},
        {title: '法人', field: 'lawyerName', align: 'center', valign: 'middle', sortable: true},
        {title: '是否确认', field: 'initializedText', align: 'center', valign: 'middle', sortable: true},
        {title: '是否失效', field: 'isdisableText', align: 'center', valign: 'middle', sortable: true},
        {title: '是否封存', field: 'closedText', align: 'center', valign: 'middle', sortable: true}
        ];
};

/**
 * 检查是否选中
 */
Company.check = function () {
    var selected = $('#' + this.id).bootstrapTreeTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Company.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加公司
 */
Company.openAddCompany = function () {
    var index = layer.open({
        type: 2,
        title: '添加公司',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/company/company_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看公司详情
 */
Company.openCompanyDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '公司详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/company/company_update/' + Company.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除部门
 */
Company.delete = function () {
    if (this.check()) {

        var operation = function(){
            var ajax = new $ax(Feng.ctxPath + "/company/delete", function () {
                Feng.success("删除成功!");
                Company.table.refresh();
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("comid",Company.seItem.id);
            ajax.start();
        };

        Feng.confirm("是否刪除该公司?", operation);
    }
};


/**
 * 确认公司
 */
Company.affirmCompany = function () {
    if (this.check()) {

        var operation = function(){
            var ajax = new $ax(Feng.ctxPath + "/company/affirmCompany", function () {
                Feng.success("确认成功!");
                Company.table.refresh();
            }, function (data) {
                Feng.error("确认失败!" + data.responseJSON.message + "!");
            });
            ajax.set("comid",Company.seItem.id);
            ajax.start();
        };

        Feng.confirm("是否确认?", operation);
    }
};

/**
 * 封存公司
 */
Company.closeCompany = function () {
    if (this.check()) {

        var operation = function(){
            var ajax = new $ax(Feng.ctxPath + "/company/closeCompany", function () {
                Feng.success("封存成功!");
                Company.table.refresh();
            }, function (data) {
                Feng.error("封存失败!" + data.responseJSON.message + "!");
            });
            ajax.set("comid",Company.seItem.id);
            ajax.start();
        };

        Feng.confirm("是否封存该部门?", operation);
    }
};

/**
 * 失效公司
 */
Company.loseCompany = function () {
    if (this.check()) {

        var operation = function(){
            var ajax = new $ax(Feng.ctxPath + "/company/loseCompany", function () {
                Feng.success("失效成功!");
                Company.table.refresh();
            }, function (data) {
                Feng.error("失效失败!" + data.responseJSON.message + "!");
            });
            ajax.set("comid",Company.seItem.id);
            ajax.start();
        };

        Feng.confirm("是否失效该公司?", operation);
    }
};

/**
 * 公司详情
 */
Company.detail = function () {
	 if (this.check()) {
	        var index = layer.open({
	            type: 2,
	            title: '公司详情',
	            area: ['800px', '420px'], //宽高
	            fix: false, //不固定
	            maxmin: true,
	            content: Feng.ctxPath + '/company/todetailPage/' + Company.seItem.id
	        });
	        this.layerIndex = index;
	    }
};

/**
 * 查询公司列表
 */
Company.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Company.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Company.initColumn();
    var table = new BSTreeTable(Company.id, "/company/list", defaultColunms);
    table.setExpandColumn(2);
    table.setIdField("comid");
    table.setCodeField("comid");
    table.setParentCodeField("pid");
    table.setExpandAll(true);
    table.init();
    Company.table = table;
});
