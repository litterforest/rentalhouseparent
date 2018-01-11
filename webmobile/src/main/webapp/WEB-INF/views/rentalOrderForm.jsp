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
					<input id="powerConsumption" name="powerConsumption" type="number" value="" placeholder="电表度数..." step="0.01" >
					
					<label for="waterConsumption" >水表度数：</label>
					<input id="waterConsumption" name="waterConsumption" type="number" value="" placeholder="用电度数..." step="0.01" >
					
					<label for="deductionAmount" >扣减费用：</label>
					<input id="deductionAmount" name="deductionAmount" type="number" value="0.00" placeholder="扣减费用..." step="0.01" >
					
					<label for="remarks" >备注：</label>
					<textarea id="remarks" name="remarks" placeholder="备注..." ></textarea>
					
					<hr />
					
					<button type="submit" >提交</button>
					
				</div>
			</form>

		</div>

		<%@ include file="include/footer.jsp"%>

	</div>
	
</body>
</html>