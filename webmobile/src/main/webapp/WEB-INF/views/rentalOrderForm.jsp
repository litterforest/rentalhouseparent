<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>收费订单</title>
<%@ include file="include/pageResources.jsp" %>
</head>
<body>

	<div data-role="page" id="page" data-dom-cache="false" >

		<%@ include file="include/header.jsp"%>

		<div data-role="content">

			<form action="${ctx }/rentalorder/save" method="post" data-ajax="false" >
				<input type="hidden" name="_csrf" value="${_csrf.token}" >
				<input type="hidden" name="rentalClientCheckinOrderId" value="${param.rentalClientCheckinOrderId}" >
				<div data-role="fieldcontain">
				
					<label for="year" >年份：</label>
					<select id="year" name="year" >
						<option value="2017">2017</option>
						<option value="2018">2018</option>
						<option value="2019">2019</option>
						<option value="2020">2020</option>
						<option value="2021">2021</option>
					</select>
					
					<label for="month" >月份：</label>
					<select id="month" name="month" >
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
					</select>
					
					<label for="powerConsumption" >电表度数：</label>
					<input id="powerConsumption" name="powerConsumption" type="number" value="" placeholder="电表度数..." >
					
					<label for="waterConsumption" >水表度数：</label>
					<input id="waterConsumption" name="waterConsumption" type="number" value="" placeholder="用电度数..." >
					
					<label for="deductionAmount" >扣减费用：</label>
					<input id="deductionAmount" name="deductionAmount" type="number" value="0.00" placeholder="扣减费用..." >
					
					<label for="remarks" >备注：</label>
					<textarea id="remarks" name="remarks" placeholder="备注..." ></textarea>
					
					<hr />
					
					<button type="submit" >提交</button>
					
				</div>
			</form>

		</div>

		<%@ include file="include/footer.jsp"%>

	</div>

	<%-- <div class="easyui-panel" style="width:100%;padding:10px;border:0;">
		<form id="inputForm" action="${ctx }/rentalorder/save" method="post" >
			<input type="hidden" name="rentalClientId" value="${param.rentalClientId}" >
			<input type="hidden" name="houseId" value="${param.houseId}" >
			<input type="hidden" name="rentalClientCheckinOrderId" value="${param.rentalClientCheckinOrderId}" >
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
	</div> --%>
	
</body>
</html>