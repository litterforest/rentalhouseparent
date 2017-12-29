<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="eleName" type="java.lang.String" required="false" description="元素名称" %>
<%@ attribute name="eleID" type="java.lang.String" required="false" description="元素ID" %>
<%@ attribute name="optionItems" type="java.util.List" required="true" description="下拉列表选项数据" %>
<%@ attribute name="isEmptyItem" type="java.lang.Boolean" required="false" description="是否创建全部选项" %>
<select id="${eleID }" name="${eleName }">
	
	<c:if test="${isEmptyItem }">
		<option value="">请选择</option>
	</c:if>
	
	<c:forEach items="${optionItems }" var="item" >
		<option value="${item.value }">${item.label }</option>
	</c:forEach>
	
</select>