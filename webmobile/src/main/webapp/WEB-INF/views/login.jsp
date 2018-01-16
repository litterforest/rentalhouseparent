<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>用户登录</title>
<%@ include file="include/pageResources.jsp"%>
</head>
<body >
	<script type="text/javascript">
		// 弹出提示信息
		<c:if test="${not empty param.errorMsg}">
			alert("${param.errorMsg}");
		</c:if>
	</script>
	<div data-role="page" id="page" data-dom-cache="false" class="loginbg" >
		
		<div data-role="content">
			<form action="${ctx }/doLogin" method="post" data-ajax="false" >
				<input type="hidden" name="_csrf" value="${_csrf.token}">
				<div data-role="fieldcontain">
					<label for="username" >用户名：</label>
        			<input type="text" name="username" id="username" placeholder="用户名" >
					<label for="password"  >密码：</label>
        			<input type="password" name="password" id="password" placeholder="密码" >
        			
        			<div data-role="fieldcontain">
        			<button type="submit" data-inline="false" >登 录</button>
        			<a href="${ctx }/register" data-role="button" data-inline="false" >免费注册</a>
        			</div>
				</div>
			</form>
		</div>
	</div>

</body>
</html>