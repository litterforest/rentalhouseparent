<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>房源信息列表</title>
<%@ include file="include/pageResources.jsp" %>
<script type="text/javascript" >
	
	$(document).ready(function() {
		
		// $("#rentalType").val("${rentalOrder.rentalType}");
		// 渲染表格和分页栏
        jQuery("#grid-table").jqGrid({
        	url : '${ctx}/RentalHouseResource/list/data?' + $("#searchForm").serialize(), //组件创建完成之后请求数据的url
				datatype : "json", //请求数据返回的类型。可选json,xml,txt
				colNames : [ '操作', '房屋名称', '房屋编号', '所属区域', '房型信息', '装修情况', '出租价格', '标准电费', '标准水费', '出租状态', '创建日期'],//表格标题
				colModel : [ //表格每一列的配置信息。包括名字，索引，宽度,对齐方式.....
				             
		             {name : '', width : 110, align : "left", sortable : false, formatter:function(cellvalue, options, rowObject){
		            	 var resultStr = "";
		            	 return resultStr;
		             }},
		             {name : 'name',index : '',width : 140,align : "center", sortable : false},
		             {name : 'houseCode',index : '',width : 140,align : "center", sortable : false},
				 	 {name : '',index : '',width : 120, align : "center", sortable : false},
		          	 {name : '',index : '',width : 100, sortable : false, align : "center", sortable : false},
		          	 {name : 'decorationSituation',index : '',width : 100, sortable : false, align : "center", sortable : false},
		          	 {name : 'rentPrice',index : '',width : 100, sortable : false, align : "center", sortable : false},
		          	 {name : 'standardElectAmount',index : '',width : 100, sortable : false, align : "center", sortable : false},
		          	 {name : 'standardWaterAmount',index : '',width : 120, sortable : false, align : "center", sortable : false},
		          	 {name : 'statusDesc',index : '',width : 120, sortable : false, align : "center", sortable : false},
		          	 {name : 'createDate',index : '',width : 120, sortable : false, align : "center", sortable : false},
		          	 
		           ],
				rowNum : 10,//一页显示多少条
				rowList : [ 10, 20, 50, 100 ],//可供用户选择一页显示多少条
				pager : '#grid-pager',//表格页脚的占位符(一般是div)的id
				mtype : "get",//向后台请求数据的ajax的类型。可选post,get
				viewrecords : true,
				autowidth: true,
				multiselect: false,
				altRows: true,
				height: 330,
				shrinkToFit: false,
				prmNames: { page: "pageRequest.currentPage", rows: "pageRequest.pageSize" },
				jsonReader: {repeatitems: false, userdata: "userdata" },
				loadComplete: function(data){
					
				},
				
    	});
    	/*创建jqGrid的操作按钮容器*/
    	/*可以控制界面上增删改查的按钮是否显示*/
    	jQuery("#grid-table").jqGrid('navGrid', '#grid-pager', {edit : false, add : false, del : false, refresh: false, search: false});
		
	});
	
	function create_onclick()
	{
		location='${ctx }/RentalHouseResource/form';
		return false;
	}
	
</script>
</head>
<body>
	<%@ include file="include/header.jsp" %>
	<form id="searchForm" action="" method="get" >
	<p>
		收租类型:<select id="rentalType" name="rentalType" >
					<option value="">全部</option>
					<option value="0">房租</option>
					<option value="1">铺租</option>
				</select>
		年份:<input id="year" name="year" type="text" value="${rentalOrder.year }" >
	</p>
	<p>
		<input type="button" value="添加" onclick="create_onclick();" > <input type="reset" value="重置" > <input type="button" value="查询" onclick="jqgridSearchData('#grid-table', '${ctx}/RentalHouseResource/list/data?' + $('#searchForm').serialize())" >
	</p>
	</form>
	
	<!-- 表格 -->
	<table id="grid-table"></table>
	<!-- 分页栏 -->
	<div id="grid-pager"></div>
	
</body>
</html>