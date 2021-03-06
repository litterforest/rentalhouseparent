<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>房客信息列表</title>
<%@ include file="include/pageResources.jsp" %>
</head>
<body>
	<div data-role="page" id="page">

		<div data-role="header" data-position="fixed" >
		    <h1>我的房客</h1>
		    <a href="${ctx }/RentalClient/form" data-role="button" class="ui-btn-right" data-icon="plus" >添加</a>
		</div>

		<div data-role="content">
			<form id="searchForm" action="${ctx }/RentalClient/list" method="get" >
				<input type="text" data-type="search" name="name" id="search" value="${rentalClientQuery.name }" placeholder="房客名称" >
			</form>
			<br />
			<ul data-role="listview" data-inset="false" data-divider-theme="a" >
				<c:set var="checkinFlag" value="0"></c:set>
				<c:set var="checkoutFlag" value="0"></c:set>
				<c:forEach items="${rentalClientList }" var="rentalClient" >
				
					<c:choose>
						<c:when test="${checkoutFlag eq 0 and rentalClient.status eq 1 }" >
							<c:set var="checkoutFlag" value="1"></c:set>
							<li data-role="list-divider" >未入住</li>
						</c:when>
						<c:when test="${checkinFlag eq 0 and rentalClient.status eq 0 }" >
							<c:set var="checkinFlag" value="1"></c:set>
							<li data-role="list-divider" >已入住</li>
						</c:when>
					</c:choose>
				
					<li><a href="${ctx }/RentalClient/detail/${rentalClient.id}">
					<h2>${rentalClient.name }</h2>
					<p>${rentalClient.mobile }，${rentalClient.idCardNo }，${rentalClient.statusDesc }</p>
					</a></li>
				</c:forEach>
			</ul>

		</div>

		<%@ include file="include/footer.jsp"%>

	</div>
</body>
</html>