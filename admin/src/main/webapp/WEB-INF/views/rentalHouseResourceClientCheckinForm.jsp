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
		<form id="inputForm" action="${ctx }/RentalHouseResource/checkin" method="post" >
			<input type="hidden" name="houseId" value="${param.rentalHouseResourceID }" >
			<input type="hidden" id="rentalClientId" name="rentalClientId" value="" >
			<input type="hidden" name="_csrf" value="${_csrf.token}" >
			
			<table>
				<tr>
					<td>选择房客</td>
					<td>
						<select id="rentalClientSelect" class="easyui-combogrid" style="width:100%" data-options="
		                    panelWidth: 800,
		                    idField: 'id',
		                    textField: 'name',
		                    url: '${ctx}/RentalClient/list/data?status=1',
		                    method: 'get',
		                    columns: [[
		                        {field:'id', title:'数据ID', width:80, align:'center'},
		                        {field:'name', title:'姓名', width:120, align:'center'},
				    	        {field:'mobile', title:'手机号码', width:120, align:'center'},
				    	        {field:'idCardNo', title:'身份证号码', width:150, align:'center'},
				    	        {field:'statusDesc', title:'租住状态', width:100, align:'center'},
		                    ]],
		                    fitColumns: true,
		                ">
            </select>
					</td>
				</tr>
				
				<tr>
					<td>入住时电表度数</td>
					<td>
						<input id="checkinPower" name="checkinPower" type="text" class="easyui-textbox" style="width:180px;" value="${rentalClient.checkinPower }" >
					</td>
				</tr>
				
				<tr>
					<td>入住时水表数</td>
					<td>
						<input id="checkinWatermeter" name="checkinWatermeter" type="text" class="easyui-textbox" style="width:180px;" value="${rentalClient.checkinWatermeter }" >
					</td>
				</tr>
				
				<%-- <tr>
					<td>租用费</td>
					<td>
						<input id="rentalAmount" name="rentalAmount" type="text" class="easyui-textbox" style="width:180px;" value="${rentalClient.rentalAmount }" >
					</td>
				</tr> --%>
				
				<tr>
					<td>押金</td>
					<td>
						<input id="depositAmount" name="depositAmount" type="text" class="easyui-textbox" style="width:180px;" value="${rentalClient.depositAmount }" >
					</td>
				</tr>
				
				<c:if test="${param.view eq 'true' }" >
				<tr>
					<td>入住时间</td>
					<td>
						<input id="checkinDate" name="checkinDate" class="easyui-textbox" style="width:180px;" value="${rentalClient.checkinDate }" >
					</td>
				</tr>
				
				<tr>
					<td>退房时间</td>
					<td>
						<input id="checkoutDate" name="checkoutDate" class="easyui-textbox" style="width:180px;" value="${rentalClient.checkoutDate }" >
					</td>
				</tr>
				</c:if>
				
				<tr>
					<td>备注</td>
					<td><input id="remarks" class="easyui-textbox" name="remarks" value="${rentalClient.remarks }" style="width:180px;" data-options="multiline:true" ></td>
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
               },
               onSubmit: function(){
                   var rentalClientID = $("#rentalClientSelect").combogrid('getValue');
                   $("#rentalClientId").val(rentalClientID);
               },
           });
       });
    </script>
	
</body>
</html>