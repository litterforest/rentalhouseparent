<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>新增房源</title>
<%@ include file="include/pageResources.jsp" %>
</head>
<body>
	
	<div data-role="page" id="page" data-dom-cache="false" >

		<%@ include file="include/header.jsp"%>

		<div data-role="content">

			<form action="" method="post" data-ajax="false" >
				
				<div data-role="fieldcontain">
				
					<label for="name" >房源名称：</label>
					<input id="name" name="name" type="text" value="${rentalHouseResource.name }" placeholder="房源名称..." >
					
					<label for="houseCode" >房源编号：</label>
					<input id="houseCode" name="houseCode" type="text" value="${rentalHouseResource.name }" placeholder="房源编号..." >
					
					<fieldset data-role="controlgroup">
						<legend>所在区域：</legend>
						<app:areaselect provinceName="provinceCityId" cityName="cityCityId" areaName="areaCityId" cityId="${rentalHouseResource.cityId }" ></app:areaselect>
					</fieldset>
					
					<label for="address" >详细地址：</label>
					<textarea id="address" name="address" rows="" cols="" placeholder="详细地址..." >${rentalHouseResource.address }</textarea>
					
					<label for="houseType" >房型：</label>
					<app:dictselect eleID="houseType" eleName="houseType" optionItems="${appfn:getDictList('rental_house_resource_house_type') }" />
					
					<label for="rentPrice" >出租价格：</label>
					<input id="rentPrice" name="rentPrice" type="number" value="${rentalHouseResource.rentPrice }" placeholder="出租价格..." >
					
					<label for="decorationSituation" >装修情况：</label>
					<textarea id="decorationSituation" name="decorationSituation" rows="" cols="" placeholder="装修情况..." >${rentalHouseResource.decorationSituation }</textarea>
					
				</div>
				
			</form>

		</div>

		<%@ include file="include/footer.jsp"%>

	</div>
	
	<%-- <div class="easyui-panel" style="width:100%;padding:10px;border:0;">
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
						<textarea rows="" cols="" id="decorationSituation" name="decorationSituation">${rentalHouseResource.decorationSituation }</textarea>
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
	</div> --%>
	
</body>
</html>