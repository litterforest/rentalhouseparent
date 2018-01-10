<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>用户注册</title>
<%@ include file="include/pageResources.jsp"%>
</head>
<body>

	<div data-role="page" id="page" data-dom-cache="false" >
		
		<%@ include file="include/header.jsp"%>
		
		<div data-role="content">
			<form action="${ctx }/doRegister" method="post">
				<input type="hidden" name="_csrf" value="${_csrf.token}">
				<div data-role="fieldcontain">
					<label for="username" >用户名：</label>
        			<input type="text" name="username" id="username" placeholder="用户名" >
					<label for="password"  >密码：</label>
        			<input type="password" name="password" id="password" placeholder="密码" >
					<label for="mobile"  >手机号码：</label>
        			<input type="text" name="mobile" id="mobile" placeholder="手机号码" >
					<label for="realname"  >真实姓名：</label>
        			<input type="text" name="realname" id="realname" placeholder="真实姓名" >
        			<br />
        			<button type="submit"  >注 册</button>
				</div>
			</form>
		</div>
		
	</div>

	<%-- <form action="${ctx }/doRegister" method="post" >
		<div class="error" >${param.errorMsg }</div>
		<table>
			<tr>
				<td>用户名</td>
				<td><input name="username" type="text" ></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input name="password" type="password" ></td>
			</tr>
			<tr>
				<td>手机号码</td>
				<td><input name="mobile" type="text" ></td>
			</tr>
			<tr>
				<td>真实姓名</td>
				<td><input name="realname" type="text" ></td>
			</tr>
			<tr>
				<td colspan="2" align="center" ><input type="submit" value="提交" >&nbsp;&nbsp;<input type="button" value="返回" onclick="location='${ctx}/login'" ></td>
			</tr>
		</table>
	</form> --%>
</body>
</html>