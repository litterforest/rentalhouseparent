<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收费订单列表</title>
<%@ include file="include/pageResources.jsp" %>
<script type="text/javascript" >
	
	$(document).ready(function() {
		
		$('#datagrid-table').datagrid({
    	    url: '${ctx}/rentalorder/list/data?' + $("#searchForm").serialize(),
    	    columns:[[
    	        {field:'id', title:'', checkbox: true},
    	        {field:'operator', title:'操作', width:120, align:'left', halign:'center', formatter: function(value,row,index){
    	        	 var resultStr = "";
	            	 resultStr += "<input type=\"button\" value=\"查看\" onclick=\"location='${ctx}/rentalorder/detail/"+ row.id +"'\" >";
	            	 return resultStr;
    			}},
    	        {field:'yearAndMonth', title:'收费日期', width:120, align:'center'},
    	        {field:'rentalAmount', title:'基本租金', width:150, align:'center'},
    	        {field:'electricityAmount', title:'电费', width:100, align:'center'},
    	        {field:'diffPowerConsumption', title:'用电度数', width:100, align:'center'},
    	        {field:'waterAmount', title:'水费', width:100, align:'center'},
    	        {field:'diffWaterConsumption', title:'用水度数', width:100, align:'center'},
    	        {field:'deductionAmount', title:'扣减费用', width:100, align:'center'},
    	        {field:'totalAmount', title:'总费用', width:220, align:'center'},
    	        {field:'statusDesc', title:'审核状态', width:220, align:'center'},
    	        {field:'createDate', title:'创建日期', width:220, align:'center'},
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
		
	});
	
	function create_onclick()
	{
		// 检查是否有订单未审核通过
		$.ajax({
		   type: "GET",
		   url: "${ctx }/rentalorder/isCreatePermission",
		   data: {rentalType : $("#rentalType").val()},
		   success: function(data){
		      if (data.status == "success")
	    	  {
		    	  location='${ctx }/rentalorder/form';
	    	  }
		      else
	    	  {
	    	  	  alert(data.msg);
	    	  }
		   }
		});
		
		
		return false;
		
	}
	
</script>
</head>
<body>
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
		<input type="button" value="添加" onclick="create_onclick();" > <input type="reset" value="重置" > <input type="button" value="查询" onclick="dataGridSearchData('#datagrid-table', '${ctx}/rentalorder/list/data?' + $('#searchForm').serialize());" >
	</p>
	</form>
	
	<!-- 表格 -->
	<table id="datagrid-table" style="height:330px;"></table>
	<div id="win" ></div>
	
</body>
</html>