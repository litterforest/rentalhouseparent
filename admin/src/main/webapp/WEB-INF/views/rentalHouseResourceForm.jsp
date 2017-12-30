<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收费订单</title>
<%@ include file="include/pageResources.jsp" %>
<script type="text/javascript">
	
</script>
</head>
<body>
	<%@ include file="include/header.jsp" %>
	<form action="${ctx }/RentalHouseResource/save" method="post" >
		<input type="hidden" name="_csrf" value="${_csrf.token}" >
		<table border="1">
			<tr>
				<td>房源名称</td>
				<td>
					<input id="name" name="name" type="text" >
				</td>
			</tr>
			<tr>
				<td>房源编号</td>
				<td>
					<input id="houseCode" name="houseCode" type="text" >
				</td>
			</tr>
			<tr>
				<td>所在区域</td>
				<td>
					<appex:areaselect provinceName="provinceCityId" cityName="cityCityId" areaName="areaCityId" ></appex:areaselect>
				</td>
			</tr>
			<tr>
				<td>房型</td>
				<td>
					<appex:dictselect eleID="houseType" eleName="houseType" optionItems="${appfn:getDictList('rental_house_resource_house_type') }" />
				</td>
			</tr>
			<tr>
				<td>出租价格</td>
				<td>
					<input id="rentPrice" name="rentPrice" type="text" >
				</td>
			</tr>
			<tr>
				<td>装修情况</td>
				<td>
					<textarea rows="" cols="" id="decorationSituation" name="decorationSituation"></textarea>
				</td>
			</tr>
			
			<tr>
				<td>标准电费</td>
				<td>
					<input id="standardElectAmount" name="standardElectAmount" >
				</td>
			</tr>
			
			<tr>
				<td>标准水费</td>
				<td>
					<input id="standardWaterAmount" name="standardWaterAmount" >
				</td>
			</tr>
			
			<tr>
				<td>用电度数</td>
				<td><input name="powerConsumption" value="" ></td>
			</tr>
			<tr>
				<td>扣减费用</td>
				<td><input name="deductionAmount" value="0.00" ></td>
			</tr>
			
			<tr>
				<td>备注</td>
				<td><textarea name="remarks" rows="" cols=""></textarea></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center" >
					<input type="submit" value="提交" >&nbsp;&nbsp;<input type="button" value="返回" onclick="location='${ctx }/RentalHouseResource/list'" >
				</td>
			</tr>
			
		</table>
	</form>
</body>
</html>