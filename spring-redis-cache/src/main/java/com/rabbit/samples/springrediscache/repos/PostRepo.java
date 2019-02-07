package com.rabbit.samples.springrediscache.repos;

import com.rabbit.samples.springrediscache.domain.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 06 Feb 2019
 */
@Repository
public interface PostRepo extends CrudRepository<Post, Long> {

	// no-op
}
