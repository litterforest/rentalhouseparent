<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>房客信息</title>
<%@ include file="include/pageResources.jsp" %>
</head>
<body>

	<div data-role="page" id="page">

		<%@ include file="include/header.jsp"%>

		<div data-role="content"  >

			<table>
				<tr>
					<td>姓名：</td>
					<td>${rentalClient.name }</td>
				</tr>
				<tr>
					<td>手机号码：</td>
					<td>${rentalClient.mobile }</td>
				</tr>
				<tr>
					<td>身份证号码：</td>
					<td>${rentalClient.idCardNo }</td>
				</tr>
				<tr>
					<td>租住状态：</td>
					<td>${rentalClient.statusDesc }</td>
				</tr>
				<tr>
					<td>备注：</td>
					<td>${rentalClient.remarks }</td>
				</tr>

			</table>
			
			<c:choose>
				<c:when test="${rentalClient.status ne 0 }">
					<button data-corners="false" disabled="disabled" >收租</button>
				</c:when>
				<c:otherwise>
					<a href="${ctx }/rentalorder/form?rentalClientCheckinOrderId=${rentalClient.currentRentalClientCheckinOrder.id}" data-role="button" data-corners="false" >收租</a>
				</c:otherwise>
			</c:choose>

		</div>

		<%@ include file="include/footer.jsp"%>

	</div>

</body>
</html>