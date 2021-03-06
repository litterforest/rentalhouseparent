<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>添加房客</title>
<%@ include file="include/pageResources.jsp" %>
</head>
<body>
	
	<div data-role="page" id="page" data-dom-cache="false" >

		<%@ include file="include/header.jsp"%>

		<div data-role="content">

			<form action="${ctx }/RentalClient/save" method="post" data-ajax="false" >
				<input type="hidden" name="_csrf" value="${_csrf.token}" >
				<div data-role="fieldcontain">
				
					<label for="name" >姓名：</label>
					<input id="name" name="name" type="text" value="${rentalClient.name }" placeholder="姓名..." required="required" >
					
					<label for="mobile" >手机号码：</label>
					<input id="mobile" name="mobile" type="number" value="${rentalClient.mobile }" placeholder="手机号码..." required="required" >
					
					<label for="idCardNo" >身份证号码：</label>
					<input id="idCardNo" name="idCardNo" type="text" value="${rentalClient.idCardNo }" placeholder="身份证号码..." required="required" >
					
					<fieldset data-role="controlgroup" data-type="horizontal" >
				        <legend>性别：</legend>
				        <label for="male">男性</label>
				        <input type="radio" name="gender" id="male" value="0">
				        <label for="female">女性</label>
				        <input type="radio" name="gender" id="female" value="1">
				    </fieldset>
					
					<%-- <label for="status" >租住状态：</label>
					<select id="status" name="status" >
						<option value="0">入住</option>
						<option value="1" selected >退房</option>
					</select> --%>
					
					<label for="remarks" >备注：</label>
					<textarea id="remarks" name="remarks" placeholder="备注..." >${rentalClient.remarks }</textarea>
					<hr />
					<button type="submit" >提交</button>
					
				</div>
			</form>

		</div>

		<%@ include file="include/footer.jsp"%>

	</div>
	
</body>
</html>