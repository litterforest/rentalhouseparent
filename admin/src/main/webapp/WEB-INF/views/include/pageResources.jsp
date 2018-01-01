<!-- ========================================css======================================== -->
<link href="${ctx}/resources/css/base.css" rel="stylesheet" />
<!-- jqgrid -->
<link rel="stylesheet" href="${ctx}/resources/js/jqgrid/4.6/css/ui.jqgrid.css" >
<link rel="stylesheet" href="${ctx}/resources/js/jqgrid/4.6/css/default/jquery-ui-1.8.2.custom.css" >
<!-- jqgrid -->
<!-- jquery easyui -->
<link rel="stylesheet" type="text/css" href="${ctx}/resources/js/jquery-easyui-1.5.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${ctx}/resources/js/jquery-easyui-1.5.3/themes/icon.css">
<!-- jquery easyui -->
<!-- ========================================css======================================== -->

<!-- ========================================js======================================== -->
<script src="${ctx}/resources/js/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/base.js" ></script>
<!-- jqgrid -->
<script type="text/javascript" src="${ctx}/resources/js/jqgrid/4.6/js/jquery.jqGrid.min.js" ></script>
<script type="text/javascript" src="${ctx}/resources/js/jqgrid/4.6/i18n/grid.locale-cn.js" ></script>
<!-- jqgrid -->
<!-- jquery easyui -->
<script type="text/javascript" src="${ctx}/resources/js/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery-easyui-1.5.3/locale/easyui-lang-zh_CN.js"></script>
<!-- jquery easyui -->
<!-- ========================================js======================================== -->
<%-- 
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<script type="text/javascript" >
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});
</script> --%>