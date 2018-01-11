<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>房源信息列表</title>
<%@ include file="include/pageResources.jsp"%>
</head>
<body>
	<div data-role="page" id="page">

		<div data-role="header" data-position="fixed" data-dom-cache="false" >
			<h1>
				我的收租宝
			</h1>
			<a href="${ctx }/RentalHouseResource/form" data-role="button"
				class="ui-btn-right" data-icon="plus">添加</a>
		</div>

		<div data-role="content">

			<ul data-role="listview" data-inset="false" >
				<c:set var="checkinFlag" value="0"></c:set>
				<c:set var="checkoutFlag" value="0"></c:set>
				<c:forEach items="${rentalHouseResourceList }" var="rentalHouseResource">
					
					<c:choose>
						<c:when test="${checkoutFlag eq 0 and rentalHouseResource.status eq 0 }" >
							<c:set var="checkoutFlag" value="1"></c:set>
							<li data-role="list-divider" data-theme="b" >待出租</li>
						</c:when>
						<c:when test="${checkinFlag eq 0 and rentalHouseResource.status eq 1 }" >
							<c:set var="checkinFlag" value="1"></c:set>
							<li data-role="list-divider" data-theme="b" >已出租</li>
						</c:when>
					</c:choose>
					
					<li ><a href="${ctx }/RentalHouseResource/detail/${rentalHouseResource.id}" >
					<h2>${rentalHouseResource.name }</h2>
					<p>${rentalHouseResource.baseArea.fullname }${rentalHouseResource.address }，${rentalHouseResource.rentPrice }，${rentalHouseResource.statusDesc }</p>
					</a></li>
				</c:forEach>
			</ul>

		</div>

		<%@ include file="include/footer.jsp"%>

	</div>
</body>
</html>