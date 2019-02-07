package com.rabbit.samples.springrediscache.configs;

import com.rabbit.samples.springrediscache.services.CacheService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 07 Feb 2019
 */
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Getter(value = AccessLevel.PROTECTED)
@Configuration
@EnableScheduling
public class SchedulingConfig {

	static final int EVICT_ALL_INTERVAL = 10000;

	CacheService cacheService;

	@Scheduled(fixedRate = EVICT_ALL_INTERVAL)
	void evictAllCaches() {

		log.info("Scheduled every {} seconds: Delete all cache", EVICT_ALL_INTERVAL);

		getCacheService().evictAll();
	}

}
