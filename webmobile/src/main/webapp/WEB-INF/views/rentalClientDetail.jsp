<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>房客信息</title>
<%@ include file="include/pageResources.jsp" %>
</head>
<body>
	<script type="text/javascript">
		
		function checkout_onclick(rentalClientID, houseID)
		{
			if (!confirm('确定租客已结清房费和押金?'))
			{
				return false;
			}
			// 执行退房功能
			$.getJSON("${ctx }/RentalClient/checkout", { id: rentalClientID, houseId: houseID }, function(data){
	    		if (data.status == "success")
   				{
   					alert("退房成功");
   					location.reload();
   				}
   				else
   				{
   					alert("提示信息:" + data.msg);
   				}
    		});
		}
	
	</script>
	<div data-role="page" id="page">

		<%@ include file="include/header.jsp"%>

		<div data-role="content"  >

			<table>
				<tr>
					<td>姓名：</td>
					<td>${rentalClient.name }</td>
				</tr>
				<tr>
					<td>手机号码：</td>
					<td>${rentalClient.mobile }</td>
				</tr>
				<tr>
					<td>身份证号码：</td>
					<td>${rentalClient.idCardNo }</td>
				</tr>
				<tr>
					<td>租住状态：</td>
					<td>${rentalClient.statusDesc }</td>
				</tr>
				
				<c:if test="${rentalClient.status eq 0 }">
					<tr>
						<td>租房名称：</td>
						<td>${rentalClient.rentalHouseResource.name }</td>
					</tr><tr>
						<td>租房地址：</td>
						<td>${rentalClient.rentalHouseResource.baseArea.fullname }${rentalClient.rentalHouseResource.address }</td>
					</tr>
				</c:if>
				
				<tr>
					<td>备注：</td>
					<td>${rentalClient.remarks }</td>
				</tr>

			</table>
			
			<c:choose>
				<c:when test="${rentalClient.status ne 0 }">
					<button data-corners="false" disabled="disabled" >收租</button>
				</c:when>
				<c:otherwise>
					<a href="${ctx }/rentalorder/form?rentalClientCheckinOrderId=${rentalClient.currentRentalClientCheckinOrder.id}" data-role="button" data-corners="false" >收租</a>
					<button data-corners="false" onclick="checkout_onclick('${rentalClient.id}','${rentalClient.rentalHouseResource.id }')" >退房</button>
				</c:otherwise>
			</c:choose>

		</div>

		<%@ include file="include/footer.jsp"%>

	</div>
	
</body>
</html>