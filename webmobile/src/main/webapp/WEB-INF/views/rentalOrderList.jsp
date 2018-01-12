<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>收费单列表</title>
<%@ include file="include/pageResources.jsp" %>
</head>
<body>
	
	<div data-role="page" id="page">

		<div data-role="header" data-position="fixed" >
		    <h1>我的收费单</h1>
		</div>

		<div data-role="content">
			<c:set var="pageYear" value="" ></c:set>
			<ul data-role="listview" data-inset="false">
				<c:forEach items="${rentalOrderList }" var="rentalOrder" >
					
					<c:if test="${pageYear ne rentalOrder.year }">
						<li data-role="list-divider" >${rentalOrder.year }年</li>
						<c:set var="pageYear" value="${rentalOrder.year }" ></c:set>
					</c:if>
					
					<li><a href="${ctx }/rentalorder/detail/${rentalOrder.id}">
						<h2>${rentalOrder.year }-${rentalOrder.monthDesc }</h2>
						<p>电费：${rentalOrder.electricityAmount }元，水费：${rentalOrder.waterAmount }元，扣减：${rentalOrder.deductionAmount }元，总费用：${rentalOrder.totalAmount }</p>
					</a></li>
					
				</c:forEach>
			</ul>

		</div>

		<%@ include file="include/footer.jsp"%>

	</div>
	
</body>
</html>