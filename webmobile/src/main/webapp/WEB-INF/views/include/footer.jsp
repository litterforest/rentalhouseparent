<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="taglib.jsp"%>
<div data-role="footer"  data-position="fixed" >
	<div data-role="navbar" >
    	<ul>
        	<li><a href="${ctx }/home" data-icon="home"  >主页</a></li>
            <li><a href="${ctx }/RentalHouseResource/list" data-icon="check" >房源</a></li>
            <li><a href="#" data-icon="check" >房客</a></li>
            <li><a href="#" data-icon="check" >收租</a></li>
            <li><a href="${ctx }/userInfo" data-icon="info">我的</a></li>
        </ul>
    </div>
</div>