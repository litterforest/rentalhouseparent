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
		    <h1>我的收租宝</h1>
		    <a href="${ctx }/RentalClient/form" data-role="button" class="ui-btn-right" data-icon="plus" >添加</a>
		</div>

		<div data-role="content">

			<ul data-role="listview" data-inset="false">
				<c:forEach items="${rentalClientList }" var="rentalClient" >
					<li><a href="${ctx }/RentalClient/detail/${rentalClient.id}">${rentalClient.name }</a></li>
				</c:forEach>
			</ul>

		</div>

		<%@ include file="include/footer.jsp"%>

	</div>
</body>
</html>