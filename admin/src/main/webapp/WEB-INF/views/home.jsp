<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>出租房管理系统</title>
<%@ include file="include/pageResources.jsp" %>
</head>
<body class="easyui-layout" >
	<%-- <div class="success" >${param.msg }</div>
	<div class="error" >${param.errorMsg }</div> --%>
	
	<!-- <div class="easyui-layout" > -->
	
		<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px;"><%@ include file="include/header.jsp" %></div>
		<div data-options="region:'west',split:true,title:'菜单栏'" style="width:13%;"><app:EasyUIAccordionMenu menus="${menus }"></app:EasyUIAccordionMenu> </div>
		<div data-options="region:'center',title:'工作区'">
			<iframe name="myIframe" width="99%" height="99%" scrolling="no" style="border: 0px;" ></iframe>
		</div>
		
		<%-- <div data-options="region:'north'" style="height:60px"><%@ include file="include/header.jsp" %></div>
		<div data-options="region:'west',split:true" title="West" style="width:180px;">
			<app:menus menus="${menus }"></app:menus>
		</div>
		<div data-options="region:'center',title:'Main Title',iconCls:'icon-ok'" >
			<iframe name="myIframe" width="99%" height="99%" scrolling="no" ></iframe>
		</div> --%>
	<!-- </div> -->
	
</body>
</html>