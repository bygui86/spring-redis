package com.rabbit.samples.springrediscache.services.impl;

import com.rabbit.samples.springrediscache.services.CacheService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 06 Feb 2019
 */
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Getter(value = AccessLevel.PROTECTED)
@Service
public class CacheServiceImpl implements CacheService {

	static String WILDCARD = "*";

	private CacheManager cacheManager;

	RedisTemplate<String, Object> redisTemplate;

	@Override
	public Set<String> getAll() {

		return getRedisTemplate().keys(WILDCARD);
	}

	@Override
	public Object getByKey(final String key) {

		return getRedisTemplate().keys(key + WILDCARD);
	}

	@Override
	public void evictAll() {

		getCacheManager()
				.getCacheNames()
				.forEach(
						cacheName -> getCacheManager().getCache(cacheName).clear()
				);
	}

	@Override
	public void evictByKey(final String key) {

		getCacheManager()
				.getCache(key)
				.clear();
	}

}
