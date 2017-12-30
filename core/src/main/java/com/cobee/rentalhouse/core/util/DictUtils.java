package com.cobee.rentalhouse.core.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.cobee.rentalhouse.core.component.SpringContextHolderBean;
import com.cobee.rentalhouse.core.entity.SysDict;
import com.cobee.rentalhouse.core.service.SysDictService;

public class DictUtils {
	
	private static SysDictService sysDictService = SpringContextHolderBean.getBean(SysDictService.class);

	public static final String CACHE_DICT_MAP = "dictMap";
	
	public static String getDictLabel(String value, String type, String defaultValue){
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(value)){
			for (SysDict dict : getDictList(type)){
				if (type.equals(dict.getType()) && value.equals(dict.getValue())){
					return dict.getLabel();
				}
			}
		}
		return defaultValue;
	}
	
	public static String getDictLabels(String values, String type, String defaultValue){
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(values)){
			List<String> valueList = new ArrayList<>();
			for (String value : StringUtils.split(values, ",")){
				valueList.add(getDictLabel(value, type, defaultValue));
			}
			return StringUtils.join(valueList, ",");
		}
		return defaultValue;
	}

	public static String getDictValue(String label, String type, String defaultLabel){
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(label)){
			for (SysDict dict : getDictList(type)){
				if (type.equals(dict.getType()) && label.equals(dict.getLabel())){
					return dict.getValue();
				}
			}
		}
		return defaultLabel;
	}
	
	public static List<SysDict> getDictList(String type){
		@SuppressWarnings("unchecked")
		Map<String, List<SysDict>> dictMap = (Map<String, List<SysDict>>)CacheUtils.get(CACHE_DICT_MAP);
		if (dictMap == null) {
			dictMap = new HashMap<>();
			for (SysDict dict : sysDictService.list(new SysDict())){
				
				List<SysDict> dictList = dictMap.get(dict.getType());
				
				if (dictList != null && dictList.size() > 0){
					
					dictList.add(dict);
					
				}else{
					
					dictList = new ArrayList<>();
					dictList.add(dict);
					dictMap.put(dict.getType(), dictList);
					
				}
			}
			CacheUtils.put(CACHE_DICT_MAP, dictMap);
		}
		List<SysDict> dictList = dictMap.get(type);
		if (dictList == null)
		{
			
			dictList = Collections.emptyList();
			
		}
		return dictList;
	}
	
	public static String getDictMaxValue(String type) {
		if (StringUtils.isNotBlank(type)) {
			int max = 0;
			try {
				for (SysDict dict : getDictList(type)) {
					if (Integer.parseInt(dict.getValue()) > max) {
						max = Integer.parseInt(dict.getValue());
					}
				}
				return Integer.toString(max);
			} catch (NumberFormatException e) {
			}
		}
		return null;
	}

	/*
	 * 反射根据对象和属性名获取属性值
	 */
	public static Object getValue(Object obj, String filed) {
		try {
			if (StringUtils.contains(filed, "."))
			{
				String[] tokens = StringUtils.split(filed, ".");
				if (tokens != null)
				{
					Class clazz = obj.getClass();
					for (int i = 0; i < tokens.length; i++)
					{

						PropertyDescriptor pd = new PropertyDescriptor(tokens[i], clazz);
						Method getMethod = pd.getReadMethod();//获得get方法

						if (pd != null) {

							Object o = getMethod.invoke(obj);//执行get方法返回一个Object
							if (i == tokens.length - 1)
							{
								return o;
							}
							else
							{
								clazz = o.getClass();
								obj = o;
							}

						}
					}
				}
			}
			else
			{
				Class clazz = obj.getClass();
				PropertyDescriptor pd = new PropertyDescriptor(filed, clazz);
				Method getMethod = pd.getReadMethod();//获得get方法

				if (pd != null) {

					Object o = getMethod.invoke(obj);//执行get方法返回一个Object
					return o;
				}
			}

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
