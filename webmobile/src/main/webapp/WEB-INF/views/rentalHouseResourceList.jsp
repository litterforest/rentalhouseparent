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

		<%@ include file="include/header.jsp"%>

		<div data-role="content">

			<ul data-role="listview" data-inset="false">
				<c:forEach items="${rentalHouseResourceList }" var="rentalHouseResource" >
					<li><a href="${ctx }/RentalHouseResource/detail/${rentalHouseResource.id}">${rentalHouseResource.name }</a></li>
				</c:forEach>
			</ul>

		</div>

		<%@ include file="include/footer.jsp"%>

	</div>
</body>
</html>