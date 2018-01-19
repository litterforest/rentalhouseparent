<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>收费单明细</title>
<%@ include file="include/pageResources.jsp"%>
</head>
<body>

	<div data-role="page" id="page">

		<%@ include file="include/header.jsp"%>

		<div data-role="content">

			<table>
				<tr>
					<td>收费年月：</td>
					<td>${rentalOrder.year }-${rentalOrder.monthDesc }</td>
				</tr>
				<tr>
					<td>出租类型：</td>
					<td>${rentalOrder.rentalClientCheckinOrder.rentalHouseResource.houseTypeDesc }</td>
				</tr>
				<tr>
					<td>月租金：</td>
					<td><fmt:formatNumber
							value="${rentalOrder.rentalClientCheckinOrder.rentalAmount }"
							groupingUsed="false" maxFractionDigits="2" minFractionDigits="2"></fmt:formatNumber></td>
				</tr>

				<tr>
					<td>电费：</td>
					<td><fmt:formatNumber
							value="${rentalOrder.electricityAmount }" groupingUsed="false"
							maxFractionDigits="2" minFractionDigits="2"></fmt:formatNumber></td>
				</tr>

				<tr>
					<td>上月电度数：</td>
					<td><fmt:formatNumber
							value="${rentalOrder.lastPowerConsumption }" groupingUsed="false"
							maxFractionDigits="2" minFractionDigits="2"></fmt:formatNumber></td>
				</tr>
				<tr>
					<td>当月电度数：</td>
					<td><fmt:formatNumber value="${rentalOrder.powerConsumption }"
							groupingUsed="false" maxFractionDigits="2" minFractionDigits="2"></fmt:formatNumber></td>
				</tr>

				<tr>
					<td>实用电度数：</td>
					<td><fmt:formatNumber
							value="${rentalOrder.diffPowerConsumption }" groupingUsed="false"
							maxFractionDigits="2" minFractionDigits="2"></fmt:formatNumber></td>
				</tr>

				<tr>
					<td>电费标准(度/元)：</td>
					<td><fmt:formatNumber
							value="${rentalOrder.rentalClientCheckinOrder.standardElectAmount }"
							groupingUsed="false" maxFractionDigits="2" minFractionDigits="2"></fmt:formatNumber>
					</td>
				</tr>

				<tr>
					<td>水费：</td>
					<td><fmt:formatNumber value="${rentalOrder.waterAmount }"
							groupingUsed="false" maxFractionDigits="2" minFractionDigits="2"></fmt:formatNumber></td>
				</tr>

				<tr>
					<td>上月水表度数：</td>
					<td><fmt:formatNumber
							value="${rentalOrder.lastWaterConsumption }" groupingUsed="false"
							maxFractionDigits="2" minFractionDigits="2"></fmt:formatNumber></td>
				</tr>
				<tr>
					<td>当月用水度数：</td>
					<td><fmt:formatNumber value="${rentalOrder.waterConsumption }"
							groupingUsed="false" maxFractionDigits="2" minFractionDigits="2"></fmt:formatNumber></td>
				</tr>

				<tr>
					<td>实用水度数：</td>
					<td><fmt:formatNumber
							value="${rentalOrder.diffWaterConsumption }" groupingUsed="false"
							maxFractionDigits="2" minFractionDigits="2"></fmt:formatNumber></td>
				</tr>

				<tr>
					<td>水费标准(度/元)：</td>
					<td><fmt:formatNumber
							value="${rentalOrder.rentalClientCheckinOrder.standardWaterAmount }"
							groupingUsed="false" maxFractionDigits="2" minFractionDigits="2"></fmt:formatNumber>
					</td>
				</tr>

				<tr>
					<td>扣减费用：</td>
					<td><fmt:formatNumber value="${rentalOrder.deductionAmount }"
							groupingUsed="false" maxFractionDigits="2" minFractionDigits="2"></fmt:formatNumber></td>
				</tr>

				<tr>
					<td>总费用：</td>
					<td><fmt:formatNumber value="${rentalOrder.totalAmount }"
							groupingUsed="false" maxFractionDigits="2" minFractionDigits="2"></fmt:formatNumber></td>
				</tr>

				<tr>
					<td>收租人：</td>
					<td>${rentalOrder.secureUser.realname }</td>
				</tr>

				<tr>
					<td>审核状态：</td>
					<td>${rentalOrder.statusDesc }</td>
				</tr>

				<tr>
					<td>备注：</td>
					<td>${rentalOrder.remarks }</td>
				</tr>

			</table>

			<%-- <c:choose>
				<c:when test="${rentalClient.status ne 0 }">
					<button data-corners="false" disabled="disabled" >收租</button>
				</c:when>
				<c:otherwise>
					<a href="${ctx }/rentalorder/form?rentalClientCheckinOrderId=${rentalClient.currentRentalClientCheckinOrder.id}" data-role="button" data-corners="false" >收租</a>
				</c:otherwise>
			</c:choose> --%>

		</div>

		<%@ include file="include/footer.jsp"%>

	</div>

</body>
</html>