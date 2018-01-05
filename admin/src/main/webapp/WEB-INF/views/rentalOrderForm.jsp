<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收费订单</title>
<%@ include file="include/pageResources.jsp" %>
<script type="text/javascript">
	function rentalType_onchange(thisObj)
	{
		
		if (thisObj.value == "0")
		{
			document.getElementById("rentalAmount").value = "2000.00";
		}
		else if (thisObj.value == "1")
		{
			document.getElementById("rentalAmount").value = "1600.00";
		}
		
	}
</script>
</head>
<body>
	<div class="easyui-panel" style="width:100%;padding:10px;border:0;">
		<form id="inputForm" action="${ctx }/rentalorder/save" method="post" >
			<input type="hidden" name="rentalClientId" value="${param.rentalClientId}" >
			<input type="hidden" name="houseId" value="${param.houseId}" >
			<input type="hidden" name="_csrf" value="${_csrf.token}" >
			<table >
				<tr>
					<td>年份</td>
					<td><select name="year" class="easyui-combobox" style="width: 180px;" >
						<option value="2017">2017</option>
						<option value="2018">2018</option>
						<option value="2019">2019</option>
						<option value="2020">2020</option>
						<option value="2021">2021</option>
					</select></td>
				</tr>
				<tr>
					<td>月份</td>
					<td><select name="month" class="easyui-combobox" style="width: 180px;" >
						<option value="1">01</option>
						<option value="2">02</option>
						<option value="3">03</option>
						<option value="4">04</option>
						<option value="5">05</option>
						<option value="6">06</option>
						<option value="7">07</option>
						<option value="8">08</option>
						<option value="9">09</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
					</select></td>
				</tr>
				
				<!-- <tr>
					<td>出租类型</td>
					<td><select name="rentalType" onchange="rentalType_onchange(this);" class="easyui-combobox" style="width: 180px;" >
						<option value="0">房租</option>
						<option value="1">铺租</option>
					</select></td>
				</tr>
				
				<tr>
					<td>出租费用</td>
					<td><input id="rentalAmount" name="rentalAmount" class="easyui-textbox" value="2000.00" style="width: 180px;" ></td>
				</tr> -->
				
				<tr>
					<td>用电度数</td>
					<td><input name="powerConsumption" value="" class="easyui-textbox" style="width: 180px;" ></td>
				</tr>
				<tr>
					<td>扣减费用</td>
					<td><input name="deductionAmount" value="0.00" class="easyui-textbox" style="width: 180px;" ></td>
				</tr>
				<tr>
					<td>备注</td>
					<td>
					<input id="remarks" class="easyui-textbox" name="remarks" value="" data-options="multiline:true" style="width: 180px;" >
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center" >
						<input type="submit" value="提交" >&nbsp;&nbsp;<input type="button" value="清空" onclick="clearEasyUIForm('#inputForm');" >
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	 <script type="text/javascript">
       $(function(){
           $('#inputForm').form({
        	   
               success:function(data){
            	   var data = eval('(' + data + ')');
                   if (data.status == "success")
	   				{
                	   
	   					$.messager.alert({title: '提示信息', msg: '创建成功，请到收费单查看数据', fn: function(){
	   						$('#win').window('close');
		   					$("#searchBtn").click();
	   					}});
	   					
	   				}
	   				else
	   				{
	   					$.messager.alert('提示信息', data.msg, 'error');
	   				}
               }
           });
       });
    </script>
	
</body>
</html>