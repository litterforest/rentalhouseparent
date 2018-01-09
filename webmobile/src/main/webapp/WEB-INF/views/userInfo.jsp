<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>我的信息</title>
<%@ include file="include/pageResources.jsp"%>
</head>
<body>

	<div data-role="page" id="page" data-dom-cache="false" >
		
		<div data-role="content">
			
			<div data-role="header" data-position="fixed" >
			    <h1><!-- 我的收租宝 --></h1>
			    <a href="${ctx }/logout" data-role="button" class="ui-btn-right" >退出</a>
			</div> 
        
			<div data-role="content" class="ui-content" >
				
			</div>
		
        	<%@ include file="include/footer.jsp"%>
			
		</div>
		
	</div>

</body>
</html>