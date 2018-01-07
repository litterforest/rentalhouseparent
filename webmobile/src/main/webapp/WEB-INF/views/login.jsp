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
<body>

	<div data-role="page" id="page">
		
		<div data-role="content">
			<form action="${ctx }/doLogin" method="post">
				<input type="hidden" name="_csrf" value="${_csrf.token}">
				<div data-role="fieldcontain">
					<label for="username" >用户名：</label>
        			<input type="text" name="username" id="username" placeholder="用户名" >
					<label for="password"  >密码：</label>
        			<input type="password" name="password" id="password" placeholder="密码" >
        			<br />
        			<button type="submit"  >登 录</button>
				</div>
			</form>
		</div>
	</div>

</body>
</html>