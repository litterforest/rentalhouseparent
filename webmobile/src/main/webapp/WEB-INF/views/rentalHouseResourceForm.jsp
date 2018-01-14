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

			<form action="${ctx }/RentalHouseResource/save" method="post" data-ajax="false" >
				
				<input type="hidden" name="_csrf" value="${_csrf.token}" >
				<input type="hidden" name="parentId" value="${param.parentHouseID}" >
				
				<div data-role="fieldcontain">
				
					<label for="name" >房源名称：</label>
					<input id="name" name="name" type="text" value="${rentalHouseResource.name }" placeholder="房源名称..." required="required" >
					
					<label for="houseCode" >房源编号：</label>
					<input id="houseCode" name="houseCode" type="text" value="${rentalHouseResource.name }" placeholder="房源编号..." >
					
					<c:if test="${param.operator ne 'addroom' }">
						<fieldset data-role="controlgroup">
							<legend>所在区域：</legend>
							<app:areaselect provinceName="baseArea.provinceCityId" cityName="baseArea.cityCityId" areaName="baseArea.areaCityId" cityId="${rentalHouseResource.cityId }" ></app:areaselect>
						</fieldset>
						
						<label for="address" >详细地址：</label>
						<textarea id="address" name="address" placeholder="详细地址..." >${rentalHouseResource.address }</textarea>
					</c:if>
					
					<label for="houseType" >房型：</label>
					<app:dictselect eleID="houseType" eleName="houseType" optionItems="${appfn:getDictList('rental_house_resource_house_type') }" />
					
					<label for="rentPrice" >出租价格：</label>
					<input id="rentPrice" name="rentPrice" type="number" value="${rentalHouseResource.rentPrice }" placeholder="出租价格..." step="0.01" required="required" >
					
					<label for="decorationSituation" >装修情况：</label>
					<textarea id="decorationSituation" name="decorationSituation" placeholder="装修情况..." required="required" >${rentalHouseResource.decorationSituation }</textarea>
					
					<label for="standardElectAmount" >标准电费：</label>
					<input id="standardElectAmount" name="standardElectAmount" type="number" value="${rentalHouseResource.standardElectAmount }" placeholder="标准电费..." step="0.01" required="required" >
					
					<label for="standardWaterAmount" >标准水费：</label>
					<input id="standardWaterAmount" name="standardWaterAmount" type="number" value="${rentalHouseResource.standardElectAmount }" placeholder="标准水费..." step="0.01" required="required" >
					
					<%-- <label for="status" >出租状态：</label>
					<select  id="status" name="status" >
						<option value="0" selected >待出租</option>
						<option value="1">已出租</option>
					</select> --%>
					
					<label for="remarks" >备注：</label>
					<textarea id="remarks" name="remarks" placeholder="备注..." >${rentalHouseResource.remarks }</textarea>
					<hr />
					<button type="submit" >提交</button>
					
				</div>
				
			</form>

		</div>

		<%@ include file="include/footer.jsp"%>

	</div>
	
</body>
</html>