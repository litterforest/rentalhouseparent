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
			<form id="searchForm" action="${ctx }/rentalorder/list" method="get" >
				<input type="text" data-type="search" name="rentalClientCheckinOrder.rentalClient.name" id="search" value="${rentalOrderQuery.rentalClientCheckinOrder.rentalClient.name }" placeholder="房客名称" >
			</form>
			<br />
			<ul data-role="listview" data-inset="false">
			
				<c:forEach items="${yearList }" var="dbYear" >
					
					<%-- <c:set var="clientName" value="" ></c:set> --%>
					<li data-role="list-divider" >${dbYear }年</li>
					
					<c:forEach items="${orderMap[dbYear] }" var="rentalOrder" >
					
						<%-- <c:if test="${clientName ne rentalOrder.rentalClientCheckinOrder.rentalClient.name }">
							<li style="font-weight: bold;" >${rentalOrder.clientDisplay }</li>
							<c:set var="clientName" value="${rentalOrder.rentalClientCheckinOrder.rentalClient.name }" ></c:set>
						</c:if> --%>
						
						<li><a href="${ctx }/rentalorder/detail/${rentalOrder.id}">
							<h2>${rentalOrder.rentalClientCheckinOrder.rentalClient.name }，${rentalOrder.year }-${rentalOrder.monthDesc }</h2>
							<p>总费用：${rentalOrder.totalAmount }，电费：${rentalOrder.electricityAmount }元，水费：${rentalOrder.waterAmount }元，扣减：${rentalOrder.deductionAmount }元</p>
						</a></li>
					</c:forEach>
					
				</c:forEach>
			
				<%-- <c:forEach items="${rentalOrderList }" var="rentalOrder" >
					
					<c:if test="${pageYear ne rentalOrder.year }">
						<li data-role="list-divider" >${rentalOrder.year }年</li>
						<c:set var="pageYear" value="${rentalOrder.year }" ></c:set>
					</c:if>
					
					<li><a href="${ctx }/rentalorder/detail/${rentalOrder.id}">
						<h2>${rentalOrder.year }-${rentalOrder.monthDesc }</h2>
						<p>总费用：${rentalOrder.totalAmount }，电费：${rentalOrder.electricityAmount }元，水费：${rentalOrder.waterAmount }元，扣减：${rentalOrder.deductionAmount }元</p>
					</a></li>
					
				</c:forEach> --%>
				
			</ul>

		</div>

		<%@ include file="include/footer.jsp"%>

	</div>
	
</body>
</html>