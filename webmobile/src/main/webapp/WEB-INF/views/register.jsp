<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>用户注册</title>
<%@ include file="include/pageResources.jsp"%>
</head>
<body>

	<script type="text/javascript">
		function submitValidate(form)
		{
			var password = form.password.value;
			var password1 = form.password1.value;
			if (password != password1)
			{
				alert("密码与确认密码不相等");
				return false;
			}
			return true;
		}
	</script>

	<div data-role="page" id="page" data-dom-cache="false" >
		
		<%@ include file="include/header.jsp"%>
		
		<div data-role="content">
			<form action="${ctx }/doRegister" method="post" onsubmit="return submitValidate(this);" >
				<input type="hidden" name="_csrf" value="${_csrf.token}">
				<div data-role="fieldcontain">
					<label for="username" >用户名：</label>
        			<input type="text" name="username" id="username" placeholder="用户名" required="required" >
					<label for="password"  >密码：</label>
        			<input type="password" name="password" id="password" placeholder="密码" required="required" >
					<label for="password1"  >确认密码：</label>
        			<input type="password" name="password1" id="password1" placeholder="确认密码" required="required"  >
					<label for="mobile"  >手机号码：</label>
        			<input type="number" name="mobile" id="mobile" placeholder="手机号码" required="required" >
					<label for="realname"  >真实姓名：</label>
        			<input type="text" name="realname" id="realname" placeholder="真实姓名" required="required" >
        			<br />
        			<button type="submit"  >注 册</button>
				</div>
			</form>
		</div>
		
	</div>

</body>
</html>