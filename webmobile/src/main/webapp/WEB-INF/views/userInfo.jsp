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

	<div data-role="page" id="page" data-dom-cache="false">

		<div data-role="content">

			<div data-role="header" data-position="fixed">
				<!-- <a href="#" data-role="button" data-rel="back" data-icon="back" >返回</a> -->
				<h1>
					我的收租宝
				</h1>
				<a href="${ctx }/logout" data-role="button" class="ui-btn-right" data-icon="alert" >退出</a>
			</div>

			<div data-role="content" class="ui-content">
				<form action="${ctx }/SecureUser/save" method="post" data-ajax="false" onsubmit="return submitValidate(this);" >
					<input name="id" type="hidden" value="${user.id }" >
					<input name="username" type="hidden" value="${user.username }" >
					<input type="hidden" name="_csrf" value="${_csrf.token}" >
					
					<div data-role="fieldcontain">
					
						<label for="password"  >密码：</label>
	        			<input type="password" name="password" id="password" placeholder="密码" required="required" >
						<label for="password1"  >确认密码：</label>
	        			<input type="password" name="password1" id="password1" placeholder="确认密码" required="required"  >
						<label for="mobile"  >手机号码：</label>
	        			<input type="number" name="mobile" id="mobile" placeholder="手机号码" required="required" value="${user.mobile }" >
	        			<br />
	        			<button type="submit"  >保 存</button>
	        			
					</div>
				</form>
			</div>
			<%@ include file="include/footer.jsp"%>
		</div>

	</div>

</body>
</html>