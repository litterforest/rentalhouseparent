<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="taglib.jsp"%>
<div data-role="footer"  data-position="fixed" >
	<div data-role="navbar" >
    	<ul>
        	<li><a href="${ctx }/home" data-icon="home"  >主页</a></li>
            <li><a href="${ctx }/RentalHouseResource/list" data-icon="action" >房源</a></li>
            <li><a href="${ctx }/RentalClient/list" data-icon="action" >房客</a></li>
            <li><a href="${ctx }/rentalorder/list" data-icon="action" >收租</a></li>
            <li><a href='${ctx }/SecureUser/userInfo/<shiro:principal property="id"/>' data-icon="user">我的</a></li>
        </ul>
    </div>
</div>