<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>我的收租宝</title>
<%@ include file="include/pageResources.jsp"%>
</head>
<body>

	<div data-role="page" id="pageone">
		
        <div data-role="header" >
        	<%--
        	<div data-role="navbar" >
            	<ul>
                	<li><a href="#" data-icon="home" >首页</a></li>
                    <li><a href="#" data-icon="search" >搜索</a></li>
                    <li><a href="#" data-icon="back">返回</a></li>
                </ul>
            </div>
            --%>
            <a href="#" data-role="button" >首页</a>
            <h1>我的收租宝</h1>
            <a href="#" data-role="button" >搜索</a>
        </div>
        
		<div data-role="content">
			主页菜单
		</div>
		
        <div data-role="footer" class="ui-btn" >
        	<a href="#" data-role="button" >首页</a>
            <a href="#" data-role="button" >搜索</a>
            <a href="#" data-role="button" >首页</a>
            <a href="#" data-role="button" >搜索</a>
        </div>
        
	</div>

</body>
</html>