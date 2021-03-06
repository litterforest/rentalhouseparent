<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<%@ attribute name="provinceName" type="java.lang.String" required="false" description="省元素名称" %>
<%@ attribute name="cityName" type="java.lang.String" required="false" description="市元素名称" %>
<%@ attribute name="areaName" type="java.lang.String" required="false" description="区元素名称" %>
<%@ attribute name="cityId" type="java.lang.Integer" required="false" description="后台cityId保存的值" %>
<%@ attribute name="isSearched" type="java.lang.Boolean" required="false" description="是否用于搜索" %>
<%@ attribute name="cls" type="java.lang.String" required="false" description="自定义样式" %>

<c:set var="provinceID" value="${fn:replace(provinceName, '.', '')}" ></c:set>
<c:set var="cityID" value="${fn:replace(cityName, '.', '')}" ></c:set>
<c:set var="areaID" value="${fn:replace(areaName, '.', '')}" ></c:set>

<input id="isAreaSearched" name="isAreaSearched" type="hidden" value="${isSearched }" >
<select id="${provinceID }" name="${provinceName }" class="${cls }" ></select>
<select id="${cityID }" name="${cityName }" class="${cls }" ></select>
<select id="${areaID }" name="${areaName }" class="${cls }" ></select>

<script type="text/javascript">
	{
	
	var provinceObj = $("#${provinceID }");
	var cityObj = $("#${cityID }");
	var areaObj = $("#${areaID }");
	
	// 省下拉选项增加onchange事件
	$("#${provinceID }").on("change", function(){
		
		if ($(this).val() != "")
		{
			$.getJSON("${ctx}/BaseData/getCitysByProvince", {parentCityId: $(this).val()}, function(data){
				  cityObj.empty();
				  $("<option value=\"\">请选择</option>").appendTo(cityObj);
				  $.each(data, function(i, item){
					  $("<option value=\""+ item.cityId +"\">"+ item.cityName +"</option>").appendTo(cityObj);
				  });
				  $("#${cityID }").change();
			});
			
		}
		else
		{
			cityObj.empty();
			areaObj.empty();
			$("<option value=\"\">请选择</option>").appendTo(cityObj);
			$("<option value=\"\">请选择</option>").appendTo(areaObj);
		}
	});
	
	// 市下拉选项增加onchange事件
	$("#${cityID }").on("change", function(){
		
		$.getJSON("${ctx}/BaseData/getAreasByCity", {parentCityId: $(this).val()}, function(data){
			  areaObj.empty();
			  $("<option value=\"\">请选择</option>").appendTo(areaObj);
			  $.each(data, function(i, item){
				  $("<option value=\""+ item.cityId +"\">"+ item.cityName +"</option>").appendTo(areaObj);
			  });
		});
		
	});
	
	//$("#${areaID }").ready(function(){
		
		provinceObj.empty();
		cityObj.empty();
		areaObj.empty();
		
		// 1，从后台加载省数据
		$("<option value=\"\">请选择</option>").appendTo(provinceObj);
		$.getJSON("${ctx}/BaseData/getProvinces", {parentCityId: 0}, function(data){
			  $.each(data, function(i, item){
				  $("<option value=\""+ item.cityId +"\">"+ item.cityName +"</option>").appendTo(provinceObj);
			  });
		});
		
		// 2,初始化市和区元素
		$("<option value=\"\">请选择</option>").appendTo(cityObj);
		$("<option value=\"\">请选择</option>").appendTo(areaObj);
		
		// 3,初始化数据库中的cityId值
		<c:if test="${not empty cityId}" >
		
			$.getJSON("${ctx}/BaseData/getFullCityIdInfo", {cityId: "${cityId}"}, function(data){
				
				  if (data.provinceCityId)
				  {
					  provinceObj.val("" + data.provinceCityId);
					  if (provinceObj.val() != "")
						{
						    
							$.getJSON("${ctx}/BaseData/getCitysByProvince", {parentCityId: provinceObj.val()}, function(data1){
								  cityObj.empty();
								  $.each(data1, function(i, item){
									  $("<option value=\""+ item.cityId +"\">"+ item.cityName +"</option>").appendTo(cityObj);
								  });
								  
								  if (data.cityCityId)
								  {
									  cityObj.val("" + data.cityCityId);
								  }
								  
								  // 加载三级区域数据
								  $.getJSON("${ctx}/BaseData/getAreasByCity", {parentCityId: cityObj.val()}, function(data2){
										  areaObj.empty();
										  $.each(data2, function(i, item){
											  $("<option value=\""+ item.cityId +"\">"+ item.cityName +"</option>").appendTo(areaObj);
										  });
										  
										  if (data.areaCityId)
										  {
											  areaObj.val("" + data.areaCityId);
										  }
										  
									});
								  
							});
							
						}
						else
						{
							cityObj.empty();
							areaObj.empty();
							$("<option value=\"\">请选择</option>").appendTo(cityObj);
							$("<option value=\"\">请选择</option>").appendTo(areaObj);
						}
				  }
				  
			});
			
		</c:if>
	}
	//});
	
</script>