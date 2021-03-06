package com.cobee.rentalhouse.core.component.shiro.cache;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.ShiroException;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.Destroyable;
import org.apache.shiro.util.Initializable;

import com.cobee.rentalhouse.core.component.redis.JedisBean;


public class RedisCacheManager implements CacheManager, Initializable, Destroyable {

	private JedisBean jedisBean;
	private int expiredTime;
	private String authorizationCacheName;

	public void setJedisBean(JedisBean jedisBean) {
		this.jedisBean = jedisBean;
	}

	public void setExpiredTime(int expiredTime) {
		this.expiredTime = expiredTime;
	}

	public void setAuthorizationCacheName(String authorizationCacheName) {
		this.authorizationCacheName = authorizationCacheName;
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() throws ShiroException {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public <K, V> Cache<K, V> getCache(String name) throws CacheException {

		if (StringUtils.equals(authorizationCacheName, name)) {
			return (Cache<K, V>) new AuthoRedisCache(jedisBean, expiredTime, name);
		}

		return null;
	}

}
