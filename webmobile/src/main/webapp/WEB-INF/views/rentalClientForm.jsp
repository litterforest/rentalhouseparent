<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>房客信息</title>
<%@ include file="include/pageResources.jsp" %>
</head>
<body>
	<div class="easyui-panel" style="width:100%;padding:10px;border:0;">
		<form id="inputForm" action="${ctx }/RentalClient/save" method="post" >
			<input type="hidden" name="id" value="${rentalClient.id }" >
			<input type="hidden" name="houseId" value="${param.rentalHouseResourceID }" >
			<input type="hidden" name="status" value="${(empty rentalClient.status) ? 1 : rentalClient.status }" >
			<input type="hidden" name="_csrf" value="${_csrf.token}" >
			<table>
				<tr>
					<td>姓名</td>
					<td>
						<input id="name" name="name" type="text" class="easyui-textbox" value="${rentalClient.name }" >
					</td>
				</tr>
				<tr>
					<td>手机号码</td>
					<td>
						<input id="mobile" name="mobile" type="text" class="easyui-textbox" value="${rentalClient.mobile }" >
					</td>
				</tr>
				<tr>
					<td>身份证号码</td>
					<td>
						<input id="idCardNo" name="idCardNo" type="text" class="easyui-textbox" value="${rentalClient.idCardNo }" >
					</td>
				</tr>
				
				<tr>
					<td>备注</td>
					<td><input id="remarks" class="easyui-textbox" name="remarks" value="${rentalClient.remarks }" data-options="multiline:true" ></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center" >
						<c:if test="${param.view ne 'true' }" >
							<input type="submit" value="提交" >&nbsp;&nbsp;<input type="button" value="清空" onclick="clearEasyUIForm('#inputForm');" >
						</c:if>
					</td>
				</tr>
				
			</table>
		</form>
	</div>
	
    <script type="text/javascript">
       $(function(){
           $('#inputForm').form({
        	   
               success:function(data){
            	   var data = eval('(' + data + ')');
                   if (data.status == "success")
	   				{
                	   
	   					$.messager.alert({title: '提示信息', msg: '创建成功', fn: function(){
	   						$('#win').window('close');
		   					$("#searchBtn").click();
	   					}});
	   					
	   				}
	   				else
	   				{
	   					$.messager.alert('提示信息', data.msg, 'error');
	   				}
               }
           });
       });
    </script>
	
</body>
</html>