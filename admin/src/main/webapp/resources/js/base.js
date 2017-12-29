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