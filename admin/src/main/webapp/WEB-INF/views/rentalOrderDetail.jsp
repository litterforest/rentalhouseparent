<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收费订单明细</title>
<%@ include file="include/pageResources.jsp" %>
</head>
<body>
	<div class="easyui-panel" style="width:100%;padding:10px;border:0;">
	<table border="1">
		<tr>
			<td>收费年月</td>
			<td>${rentalOrder.year }-${rentalOrder.month }</td>
		</tr>
		<%-- <tr>
			<td>出租类型</td>
			<td>${rentalOrder.rentalTypeDesc }</td>
		</tr> --%>
		<tr>
			<td>月租金</td>
			<td><fmt:formatNumber value="${rentalOrder.rentalClientCheckinOrder.rentalAmount }" groupingUsed="false" maxFractionDigits="2" minFractionDigits="2" ></fmt:formatNumber></td>
		</tr>
		
		<tr>
			<td>电费</td>
			<td><fmt:formatNumber value="${rentalOrder.electricityAmount }" groupingUsed="false" maxFractionDigits="2" minFractionDigits="2" ></fmt:formatNumber></td>
		</tr>
		
		<tr>
			<td>上月电度数</td> 
			<td><fmt:formatNumber value="${rentalOrder.lastPowerConsumption }" groupingUsed="false" maxFractionDigits="2" minFractionDigits="2" ></fmt:formatNumber></td>
		</tr>
		<tr>
			<td>当月电度数</td>
			<td><fmt:formatNumber value="${rentalOrder.powerConsumption }" groupingUsed="false" maxFractionDigits="2" minFractionDigits="2" ></fmt:formatNumber></td>
		</tr>
		
		<tr>
			<td>实用电度数</td>
			<td><fmt:formatNumber value="${rentalOrder.diffPowerConsumption }" groupingUsed="false" maxFractionDigits="2" minFractionDigits="2" ></fmt:formatNumber></td>
		</tr>
		
		<tr>
			<td>电费标准(度/元)</td>
			<td> 
				<fmt:formatNumber value="${rentalOrder.rentalClientCheckinOrder.standardElectAmount }" groupingUsed="false" maxFractionDigits="2" minFractionDigits="2" ></fmt:formatNumber>
			</td>
		</tr>
		
		<tr>
			<td>水费</td>
			<td><fmt:formatNumber value="${rentalOrder.waterAmount }" groupingUsed="false" maxFractionDigits="2" minFractionDigits="2" ></fmt:formatNumber></td>
		</tr>
		
		<tr>
			<td>上月水表度数</td> 
			<td><fmt:formatNumber value="${rentalOrder.lastWaterConsumption }" groupingUsed="false" maxFractionDigits="2" minFractionDigits="2" ></fmt:formatNumber></td>
		</tr>
		<tr>
			<td>当月用水度数</td>
			<td><fmt:formatNumber value="${rentalOrder.waterConsumption }" groupingUsed="false" maxFractionDigits="2" minFractionDigits="2" ></fmt:formatNumber></td>
		</tr>
		
		<tr>
			<td>实用水度数</td>
			<td><fmt:formatNumber value="${rentalOrder.diffWaterConsumption }" groupingUsed="false" maxFractionDigits="2" minFractionDigits="2" ></fmt:formatNumber></td>
		</tr>
		
		<tr>
			<td>电费标准(度/元)</td>
			<td> 
				<fmt:formatNumber value="${rentalOrder.rentalClientCheckinOrder.standardWaterAmount }" groupingUsed="false" maxFractionDigits="2" minFractionDigits="2" ></fmt:formatNumber>
			</td>
		</tr>
		
		<tr>
			<td>扣减费用</td>
			<td><fmt:formatNumber value="${rentalOrder.deductionAmount }" groupingUsed="false" maxFractionDigits="2" minFractionDigits="2" ></fmt:formatNumber></td>
		</tr>
		
		<tr>
			<td>总费用</td> 
			<td><fmt:formatNumber value="${rentalOrder.totalAmount }" groupingUsed="false" maxFractionDigits="2" minFractionDigits="2" ></fmt:formatNumber></td>
		</tr>
		
		<tr>
			<td>收租人</td> 
			<td>${rentalOrder.secureUser.realname }</td>
		</tr>
		
		<tr>
			<td>审核状态</td> 
			<td>${rentalOrder.statusDesc }</td>
		</tr>
		
		<tr>
			<td>备注</td>
			<td>${rentalOrder.remarks }</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center" >
			<c:if test="${q eq 1 }">
				<input type="button"
				value="审核" onclick="location='${ctx }/rentalorder/audit/${rentalOrder.id }'" >
			</c:if>
		</tr>

	</table>
	</div>
</body>
</html>