<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>房源信息列表</title>
<%@ include file="include/pageResources.jsp" %>
<script type="text/javascript" >
	
	$(document).ready(function() {
    	
    	$('#datagrid-table').datagrid({
    	    url: '${ctx}/RentalHouseResource/list/data?' + $("#searchForm").serialize(),
    	    columns:[[
    	        {field:'id', title:'', checkbox: true},
    	        {field:'operator', title:'操作', width:120, align:'left', halign:'center', formatter: function(value,row,index){
    	        	 var resultStr = "";
	            	 resultStr += "<input type=\"button\" value=\"查看\" onclick=\"view_onclick("+ row.id +")\" >";
	            	 if (row.status == 0)
            		 {
	            		 resultStr += "<input type=\"button\" value=\"入住\" onclick=\"checkin_onclick("+ row.id +")\" >";
            		 }
	            	 return resultStr;
    			}},
    	        {field:'name', title:'房屋名称', width:140, align:'center'},
    	        {field:'houseCode', title:'房屋编号', width:140, align:'center'},
    	        {field:'areaAddress', title:'所属区域', width:180, align:'center', formatter: function(value,row,index){
    	        	 return "<span title='" + value + "'>" + value + "</span>";
				}},
    	        {field:'houseTypeDesc', title:'房型', width:100, align:'center'},
    	        {field:'decorationSituation', title:'装修情况', width:180, align:'center'},
    	        {field:'rentPrice', title:'出租价格', width:100, align:'center'},
    	        {field:'standardElectAmount', title:'标准电费', width:100, align:'center'},
    	        {field:'standardWaterAmount', title:'标准水费', width:100, align:'center'},
    	        {field:'statusDesc', title:'出租状态', width:100, align:'center'},
    	        {field:'rentalClientName', title:'租客名称', width:100, align:'center'},
    	        {field:'createDate', title:'创建日期', width:140, align:'center'},
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
    	    width: 450,
    	    height: 500,
    	    minimizable: false,
    	    modal: true,
    	    closed: true
    	});
    	
		
	});
	
	function create_onclick()
	{
		$('#win').window({title: "添加房源信息"});
		$('#win').window('open');
		$('#win').window('refresh', '${ctx }/RentalHouseResource/form');
	}
	
	function view_onclick(id)
	{
		$('#win').window({title: "查看房源信息"});
		$('#win').window('open');
		$('#win').window('refresh', '${ctx }/RentalHouseResource/form?view=true&id=' + id);
	}
	
	function checkin_onclick(rentalHouseResourceID)
	{
		$('#win').window({title: "房客入住"});
		$('#win').window('open');
		$('#win').window('refresh', '${ctx }/RentalHouseResource/rentalHouseResourceClientCheckinForm?rentalHouseResourceID=' + rentalHouseResourceID);
	}
	
	function checkout_onclick(rentalHouseResourceID, rentalClientName)
	{
		$.messager.confirm('请确认', '确保租客['+ rentalClientName +']已经交清房费和退还押金与其它杂费?' ,function(r){
		    if (r){
		    	
		        // 发送ajax请求到后台退房
		    	$.getJSON("${ctx }/RentalHouseResource/", { name: "John", time: "2pm" }, function(data){
	    		  	
	    		});
		        
		    }
		});
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
		<input type="button" value="添加" onclick="create_onclick();" > <input type="reset" value="重置" > <input id="searchBtn" type="button" value="查询" onclick="dataGridSearchData('#datagrid-table', '${ctx}/RentalHouseResource/list/data?' + $('#searchForm').serialize());" >
	</p>
	</form>
	
	<!-- 表格 -->
	<table id="datagrid-table" style="height:330px;"></table>
	<div id="win" ></div>
</body>
</html>