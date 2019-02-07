package com.rabbit.samples.springrediscache.services;

import java.util.Set;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 06 Feb 2019
 */
public interface CacheService {

	Set<String> getAll();

	Object getByKey(final String key);

	void evictAll();

	void evictByKey(final String key);

}
