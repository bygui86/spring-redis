package com.rabbit.samples.springrediscache.services;

import com.rabbit.samples.springrediscache.domain.Post;

import java.util.List;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 06 Feb 2019
 */
public interface PostService {

	List<Post> getAll();

	Post getById(final Long id);

	Post insert(final Post post);

	Post update(final Post post);

	void deleteAll();

	void deleteById(final Long id);

	Post getErrorPost(final String errMsg);

}
