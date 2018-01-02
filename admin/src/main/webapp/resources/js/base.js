/**
 * jqGrid查询方法
 * 
 * @param gridTableID jqgrid-table的ID
 * @param url 数据查询的URL
 * @returns
 */
function jqgridSearchData(gridTableID, requestUrl)
{
	jQuery(gridTableID).jqGrid('setGridParam', 
			{ url : requestUrl, page : 1 }).trigger("reloadGrid");
}

function dataGridSearchData(gridTableID, requestUrl)
{
	var opts = $(gridTableID).datagrid('options');
    var pager = $(gridTableID).datagrid('getPager');
    opts.pageNumber = 1;
	opts.pageSize = opts.pageSize;
    pager.pagination('refresh',{
    	pageNumber:1,
    	pageSize:opts.pageSize
	});
	$(gridTableID).datagrid('options').url = requestUrl;
	$(gridTableID).datagrid('reload');
}

function clearEasyUIForm(formID){
    $(formID).form('clear');
}