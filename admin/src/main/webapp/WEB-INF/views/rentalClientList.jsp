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
    	        {field:'operator', title:'操作', width:120, align:'left', halign:'center', formatter: function(value,row,index){
    	        	 var resultStr = "";
	            	 resultStr += "<input type=\"button\" value=\"查看\" onclick=\"return view_onclick("+ row.id +")\" >";
	            	 
	            	 if (row.status == 0)
            		 {
	            		 resultStr += "<input type=\"button\" value=\"退房\" onclick=\"return checkout_onclick('"+ row.id +"', '"+ row.houseId +"')\" >";
            		 }
	            	 
	            	 return resultStr;
    			}},
    	        {field:'name', title:'姓名', width:120, align:'center'},
    	        {field:'mobile', title:'手机号码', width:120, align:'center'},
    	        {field:'idCardNo', title:'身份证号码', width:150, align:'center'},
    	        {field:'statusDesc', title:'租住状态', width:100, align:'center'},
    	        {field:'rentalHouseResourceName', title:'租房名称', width:100, align:'center'},
    	        {field:'rentalHouseResourceAddress', title:'租房地址', width:180, align:'center'},
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
		$('#win').window({title: '添加房客信息'});
		$('#win').window('open');
		$('#win').window('refresh', '${ctx }/RentalClient/form');
		return false;
	}
	
	function view_onclick(id)
	{
		$('#win').window({title: '查看房客信息'});
		$('#win').window('open');
		$('#win').window('refresh', '${ctx }/RentalClient/form?view=true&id=' + id);
		return false;
	}

	function checkout_onclick(rentalClientID, houseID)
	{
		$.messager.confirm('请确认', '确定租客已结清房费和押金?' ,function(r){
		    if (r){
		    	
		        // 发送ajax请求到后台退房
		    	$.getJSON("${ctx }/RentalClient/checkout", { id: rentalClientID, houseId: houseID }, function(data){
		    		if (data.status == "success")
	   				{
	   					$.messager.alert('提示信息', '退房成功');
	   					$('#win').window('close');
	   					$("#searchBtn").click();
	   				}
	   				else
	   				{
	   					$.messager.alert('提示信息', data.msg);
	   				}
	    		});
		        
		    }
		});
	}
	
</script>
</head>
<body>
	<form id="searchForm" action="" method="get" >
	<p>
		姓名:<input id="name" name="name" type="text" value="" >
		手机号码:<input id="mobile" name="mobile" type="text" value="" >
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