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

	<div data-role="page" id="page">
		
        <div data-role="header" data-position="fixed" >
		    <h1>我的收租宝</h1>
		</div>
        
		<div data-role="content" class="ui-content" >
			<div class="ui-grid-b">
			
				<div class="ui-block-a">
					<a href="${ctx }/RentalHouseResource/list" data-role="button">房源信息</a>
				</div>
				
				<div class="ui-block-b">
					<a href="${ctx }/RentalClient/list" data-role="button">房客信息</a>
				</div>
				
				<div class="ui-block-c">
					<a href="${ctx }/rentalorder/list" data-role="button">收费信息</a>
				</div>
				
			</div>
		</div>
		
        <%@ include file="include/footer.jsp"%>
        
	</div>

</body>
</html>