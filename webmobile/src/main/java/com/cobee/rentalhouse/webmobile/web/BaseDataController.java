package com.cobee.rentalhouse.webmobile.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cobee.rentalhouse.core.entity.BaseArea;
import com.cobee.rentalhouse.core.service.BaseAreaService;
import com.cobee.rentalhouse.core.util.CacheUtils;
import com.cobee.rentalhouse.webmobile.web.support.AbstractController;

/**
 * <pre>基础数据控制器</pre>
 * @author 陈淦森
 * @version 1.0.1
 * @date 2017年12月30日
 *
 */
@Controller
@RequestMapping("/BaseData")
public class BaseDataController extends AbstractController {
	
	/**
	 * ehcache缓存，省数据
	 */
	private static final String PROVINCES = "provinces_list";
	/**
	 * ehcache缓存，市数据
	 */
	private static final String CITYS_MAP = "citys_map";
	/**
	 * ehcache缓存，区数据
	 */
	private static final String AREAS_MAP = "areas_map";
	
	@Autowired
	private BaseAreaService baseAreaService;

	@GetMapping(value = "/getProvinces", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<BaseArea> getProvinces(BaseArea baseArea)
	{
		List<BaseArea> baseAreaList = (List<BaseArea>) CacheUtils.get(PROVINCES);
		if (CollectionUtils.isEmpty(baseAreaList))
		{
			baseAreaList = baseAreaService.list(baseArea);
			CacheUtils.put(PROVINCES, baseAreaList);
		}
		return baseAreaList;
	}
	
	@GetMapping(value = "/getCitysByProvince", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<BaseArea> getCitysByProvince(BaseArea baseArea)
	{
		List<BaseArea> baseAreaList = null;
		Map<Integer, List<BaseArea>> map = (Map<Integer, List<BaseArea>>) CacheUtils.get(CITYS_MAP);
		if (map == null)
		{
			baseAreaList = baseAreaService.list(baseArea);
			map = new HashMap<>();
			map.put(baseArea.getParentCityId(), baseAreaList);
			CacheUtils.put(CITYS_MAP, map);
		}
		else
		{
			if (map.containsKey(baseArea.getParentCityId()))
			{
				baseAreaList = map.get(baseArea.getParentCityId());
			}
			else
			{
				baseAreaList = baseAreaService.list(baseArea);
				map.put(baseArea.getParentCityId(), baseAreaList);
				CacheUtils.put(CITYS_MAP, map);
			}
		}
		return baseAreaList;
	}
	
	@GetMapping(value = "/getAreasByCity", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<BaseArea> getAreasByCity(BaseArea baseArea)
	{
		List<BaseArea> baseAreaList = null;
		Map<Integer, List<BaseArea>> map = (Map<Integer, List<BaseArea>>) CacheUtils.get(AREAS_MAP);
		if (map == null)
		{
			baseAreaList = baseAreaService.list(baseArea);
			map = new HashMap<>();
			map.put(baseArea.getParentCityId(), baseAreaList);
			CacheUtils.put(AREAS_MAP, map);
		}
		else
		{
			if (map.containsKey(baseArea.getParentCityId()))
			{
				baseAreaList = map.get(baseArea.getParentCityId());
			}
			else
			{
				baseAreaList = baseAreaService.list(baseArea);
				map.put(baseArea.getParentCityId(), baseAreaList);
				CacheUtils.put(AREAS_MAP, map);
			}
		}
		return baseAreaList;
	}
	
	@GetMapping(value = "/getFullCityIdInfo", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Map<String, Object> getFullCityIdInfo(BaseArea baseArea)
	{
		Map<String, Object> resultMap = new HashMap<>();
		BaseArea dbBaseArea = baseAreaService.get(baseArea.getCityId());
		if (dbBaseArea != null)
		{
			if (dbBaseArea.getCityCode().length() == 6)
			{
				resultMap.put("areaCityId", dbBaseArea.getCityId());
				dbBaseArea = baseAreaService.get(dbBaseArea.getParentCityId());
				resultMap.put("cityCityId", dbBaseArea.getCityId());
				dbBaseArea = baseAreaService.get(dbBaseArea.getParentCityId());
				resultMap.put("provinceCityId", dbBaseArea.getCityId());
			}
			else if (dbBaseArea.getCityCode().length() == 4)
			{
				resultMap.put("cityCityId", dbBaseArea.getCityId());
				dbBaseArea = baseAreaService.get(dbBaseArea.getParentCityId());
				resultMap.put("provinceCityId", dbBaseArea.getCityId());
			}
			else if (dbBaseArea.getCityCode().length() == 2)
			{
				resultMap.put("provinceCityId", dbBaseArea.getCityId());
			}
		}
		return resultMap;
	}
	
}
