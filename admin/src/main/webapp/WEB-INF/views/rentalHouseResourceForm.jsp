<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收费订单</title>
<%@ include file="include/pageResources.jsp" %>
</head>
<body>
	<div class="easyui-panel" style="width:100%;padding:10px;border:0;">
		<form id="inputForm" action="${ctx }/RentalHouseResource/saveByAjax" method="post" >
			<input type="hidden" name="id" value="${rentalHouseResource.id }" >
			<input type="hidden" name="_csrf" value="${_csrf.token}" >
			<table>
				<tr>
					<td>房源名称</td>
					<td>
						<input id="name" name="name" type="text" class="easyui-textbox" value="${rentalHouseResource.name }" >
					</td>
				</tr>
				<tr>
					<td>房源编号</td>
					<td>
						<input id="houseCode" name="houseCode" type="text" class="easyui-textbox" value="${rentalHouseResource.houseCode }" >
					</td>
				</tr>
				<tr>
					<td>所在区域</td>
					<td>
						<appex:areaselect provinceName="provinceCityId" cityName="cityCityId" areaName="areaCityId" cityId="${rentalHouseResource.cityId }" ></appex:areaselect>
					</td>
				</tr>
				<tr>
					<td>详细地址</td>
					<td>
						<input name="address" type="text" class="easyui-textbox" value="${rentalHouseResource.address }" >
					</td>
				</tr>
				<tr>
					<td>房型</td>
					<td>
						<appex:dictselect cls="easyui-combobox" eleID="houseType" eleName="houseType" optionItems="${appfn:getDictList('rental_house_resource_house_type') }" />
					</td>
				</tr>
				<tr>
					<td>出租价格</td>
					<td>
						<input id="rentPrice" name="rentPrice" type="text" class="easyui-textbox" value="${rentalHouseResource.rentPrice }" >
					</td>
				</tr>
				<tr>
					<td>装修情况</td>
					<td>
						<%-- <textarea rows="" cols="" id="decorationSituation" name="decorationSituation">${rentalHouseResource.decorationSituation }</textarea> --%>
						<input id="decorationSituation" class="easyui-textbox" name="decorationSituation" value="${rentalHouseResource.decorationSituation }" data-options="multiline:true" >
					</td>
				</tr>
				
				<tr>
					<td>标准电费</td>
					<td>
						<input id="standardElectAmount" name="standardElectAmount" class="easyui-textbox" value="${rentalHouseResource.standardElectAmount }" >
					</td>
				</tr>
				
				<tr>
					<td>标准水费</td>
					<td>
						<input id="standardWaterAmount" name="standardWaterAmount" class="easyui-textbox" value="${rentalHouseResource.standardWaterAmount }" >
					</td>
				</tr>
				
				<tr>
					<td>出租状态</td>
					<td>
						<select  id="status" name="status" class="easyui-combobox" >
							<option value="0">待出租</option>
							<option value="1">已出租</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td>备注</td>
					<td><input id="remarks" class="easyui-textbox" name="remarks" value="${rentalHouseResource.remarks }" data-options="multiline:true" ></td>
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
	   					$.messager.alert('提示信息', '创建成功');
	   					$('#win').window('close');
	   					$("#searchBtn").click();
	   				}
	   				else
	   				{
	   					$.messager.alert('提示信息', data.msg);
	   				}
               }
           });
       });
    </script>
	
</body>
</html>