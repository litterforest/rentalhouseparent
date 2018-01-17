<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp"%>
<%@ include file="include/globals.jsp"%>
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
		
		var verificationCodeFun = {
			countDownChecked: 0,
			send:function()
			{   
				// 未点击“获取验证码”按钮
				if (verificationCodeFun.countDownChecked == 0)
				{
					
					var numbers = /^1\d{10}$/;
					var mobile = $('#mobile').val().replace(/\s+/g, "");
					if(mobile.length == 0 || !numbers.test(mobile))
					{
						alert("请输入正确的手机号码");
						return false;
					}
					else
					{
						// 向服务器发送获取验证码的请求 
						$.getJSON("${ctx}/sendVerificationCode", { mobile: mobile }, function(data){
						    if (data.status == "success")
					    	{
						    	verificationCodeFun.countDownChecked = 1;
								verificationCodeFun.send();
								$("#verificationCodeBtn").addClass("ui-state-disabled");
					    	}
						    else if(data.status == "fail")
					    	{
					    		alert(data.msg);
					    	}
						});
						// return false;
					}
					
				}
				// 处于倒数状态
				else if (verificationCodeFun.countDownChecked == 1)
				{
					var time = 60;
					function timeCountDown()
					{    
						if(time == 0)
						{
							clearInterval(timer);
							verificationCodeFun.countDownChecked = 0;
							$("#verificationCodeBtn").text("获取验证码");
							$("#verificationCodeBtn").removeClass("ui-state-disabled");
							return false;
						}
						$("#verificationCodeBtn").text(time + "S后再次发送");
						time--;
						return false;
					}
					timeCountDown();
					var timer = setInterval(timeCountDown, 1000);
				}
				  
			} 
		} 
		
		// 弹出提示信息
		<c:if test="${not empty errorMsg}">
			alert("${errorMsg}");
		</c:if>
	</script>
		
	</script>

	<div data-role="page" id="page" data-dom-cache="false" >
		
		<div data-role="header" data-position="fixed" >
		    <a href="${ctx }/login" data-role="button" data-icon="back" >返回</a>
		    <h1>${appName }</h1>
		</div> 
		
		<div data-role="content">
			<form action="${ctx }/doRegister" method="post" onsubmit="return submitValidate(this);" data-ajax="false" >
				<input type="hidden" name="_csrf" value="${_csrf.token}">
				<div data-role="fieldcontain">
					<label for="mobile"  >手机号码：</label>
        			<input type="number" name="mobile" id="mobile" placeholder="手机号码" required="required" >
        			
					<%-- <label for="username" >用户名：</label>
        			<input type="text" name="username" id="username" placeholder="用户名" required="required" > --%>
        			
					<label for="password"  >密码：</label>
        			<input type="password" name="password" id="password" placeholder="密码" required="required" >
					<label for="password1"  >确认密码：</label>
        			<input type="password" name="password1" id="password1" placeholder="确认密码" required="required"  >
					
					<label for="realname"  >真实姓名：</label>
        			<input type="text" name="realname" id="realname" placeholder="真实姓名" required="required" >
        			
        			<label for="verificationCode">验证码：</label>
        			<input type="number" name="verificationCode" id="verificationCode" placeholder="短信验证码" required="required" data-role="none" style="height:26px;" >
        			&nbsp;&nbsp;&nbsp;&nbsp;<a id="verificationCodeBtn" href="#" data-role="none" data-inline="true" style="text-decoration: underline;" onclick="return verificationCodeFun.send();" >获取验证码</a>
        			<hr />
        			<button type="submit"  >注 册</button>
				</div>
			</form>
		</div>
		
	</div>

</body>
</html>