package com.rabbit.samples.springrediscache.configs;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 06 Feb 2019
 */
@Configuration
@EnableCaching
public class CacheConfig {

	/*
		Define a Jedis connection factory
	 */
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {

		return new JedisConnectionFactory();
	}

	/*
		Use the Jedis connection factory in the RedisTemplate
	 */
	@Bean
	RedisTemplate<String, Object> redisTemplate() {

		final RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(jedisConnectionFactory());
		return template;
	}

}
