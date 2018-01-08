<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>我的收租宝</title>
<%@ include file="include/pageResources.jsp"%>
</head>
<body>

	<div data-role="page" id="pageone">
		
        <%@ include file="include/header.jsp"%>
        
		<div data-role="content" class="ui-content" >
			<div class="ui-grid-b">
			
				<div class="ui-block-a">
					<a href="${ctx }/RentalHouseResource/list" data-role="button">房源信息</a>
				</div>
				
				<div class="ui-block-b">
					<a href="#" data-role="button">房客信息</a>
				</div>
				
				<div class="ui-block-c">
					<a href="#" data-role="button">收费信息</a>
				</div>
				
			</div>
		</div>
		
        <%@ include file="include/footer.jsp"%>
        
	</div>

</body>
</html>