<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>房客信息列表</title>
<%@ include file="include/pageResources.jsp" %>
<script type="text/javascript" >
	
	$(document).ready(function() {
    	
    	$('#datagrid-table').datagrid({
    	    url: '${ctx}/RentalClient/list/data?' + $("#searchForm").serialize(),
    	    columns:[[
    	        {field:'id', title:'', checkbox: true},
    	        {field:'operator', title:'操作', width:100, align:'left', halign:'center', formatter: function(value,row,index){
    	        	 var resultStr = "";
	            	 resultStr += "<input type=\"button\" value=\"查看\" onclick=\"view_onclick("+ row.id +")\" >";
	            	 return resultStr;
    			}},
    	        {field:'name', title:'姓名', width:140, align:'center'},
    	        {field:'mobile', title:'手机号码', width:140, align:'center'},
    	        {field:'idCardNo ', title:'身份证号码', width:180, align:'center'},
    	        {field:'checkinPower', title:'入住时电表度数', width:100, align:'center'},
    	        {field:'checkinWatermeter', title:'入住时水表数', width:180, align:'center'},
    	        {field:'rentalAmount', title:'租用费', width:100, align:'center'},
    	        {field:'depositAmount', title:'押金', width:100, align:'center'},
    	        {field:'checkinDate', title:'入住时间', width:100, align:'center'},
    	        {field:'checkoutDate', title:'退房时间', width:100, align:'center'},
    	    ]],
    	    method: 'get',
    	    pageList: [10,20,30,50,100],
    	    pagination: true,
    	    onBeforeLoad : function(param){
    	    	// 在请求中增加后台分页类使用到的参数名称值
	   	    	param["pageRequest.currentPage"] = param.page;
	   	    	param["pageRequest.pageSize"] = param.rows;
   	    	}
    	});
    	
    	$('#win').window({
    		title: '添加房客信息',
    	    width: 450,
    	    height: 500,
    	    minimizable: false,
    	    modal: true,
    	    closed: true
    	});
		
	});
	
	function create_onclick()
	{
		$('#win').window('open');
		$('#win').window('refresh', '${ctx }/RentalClient/form');
	}
	
	function view_onclick(id)
	{
		$('#win').window('open');
		$('#win').window('refresh', '${ctx }/RentalClient/form?view=true&id=' + id);
	}

	
</script>
</head>
<body>
	<form id="searchForm" action="" method="get" >
	<p>
		房型:<appex:dictselect eleID="houseType" eleName="houseType" optionItems="${appfn:getDictList('rental_house_resource_house_type') }" isEmptyItem="true" />
		房屋名称:<input id="name" name="name" type="text" value="" >
	</p>
	<p>
		<input type="button" value="添加" onclick="create_onclick();" > <input type="reset" value="重置" > <input id="searchBtn" type="button" value="查询" onclick="dataGridSearchData('#datagrid-table', '${ctx}/RentalClient/list/data?' + $('#searchForm').serialize());" >
	</p>
	</form>
	
	<!-- 表格 -->
	<table id="datagrid-table" style="height:330px;"></table>
	<div id="win" ></div>
</body>
</html>