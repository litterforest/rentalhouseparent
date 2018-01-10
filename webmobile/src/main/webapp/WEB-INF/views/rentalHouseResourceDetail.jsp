<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>房源信息列表</title>
<%@ include file="include/pageResources.jsp"%>
</head>
<body>
	<div data-role="page" id="page">

		<div data-role="header" data-position="fixed" >
			
		    <c:if test="${rentalHouseResource.status eq 0 }">
		    	<a href="${ctx }/RentalHouseResource/rentalHouseResourceClientCheckinForm?rentalHouseResourceID=${rentalHouseResource.id}" data-role="button" data-icon="plus" >房客入住</a>
		    </c:if>
		    <h1><!-- 我的收租宝 --></h1>
		    <a href="#" data-role="button" data-rel="back" class="ui-btn-right" data-icon="back" >返回</a>
		    
		</div>

		<div data-role="content">

			<table>
				<tr>
					<td>房源名称：</td>
					<td>${rentalHouseResource.name }</td>
				</tr>
				<tr>
					<td>房源编号：</td>
					<td>${rentalHouseResource.houseCode }</td>
				</tr>
				<tr>
					<td>房源地址：</td>
					<td>${rentalHouseResource.houseAddress }</td>
				</tr>
				<tr>
					<td>房型：</td>
					<td>${rentalHouseResource.houseTypeDesc }</td>
				</tr>
				<tr>
					<td>出租价格：</td>
					<td>${rentalHouseResource.rentPrice }</td>
				</tr>
				<tr>
					<td>装修情况：</td>
					<td>
						${rentalHouseResource.decorationSituation }
					</td>
				</tr>

				<tr>
					<td>标准电费：</td>
					<td>${rentalHouseResource.standardElectAmount }</td>
				</tr>

				<tr>
					<td>标准水费：</td>
					<td>${rentalHouseResource.standardWaterAmount }</td>
				</tr>

				<tr>
					<td>出租状态：</td>
					<td>${rentalHouseResource.statusDesc }</td>
				</tr>

				<tr>
					<td>备注：</td>
					<td>${rentalHouseResource.remarks }</td>
				</tr>

			</table>

		</div>

		<%@ include file="include/footer.jsp"%>

	</div>
</body>
</html>