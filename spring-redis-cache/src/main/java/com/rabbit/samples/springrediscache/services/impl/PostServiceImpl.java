package com.rabbit.samples.springrediscache.services.impl;

import com.rabbit.samples.springrediscache.domain.Post;
import com.rabbit.samples.springrediscache.repos.PostRepo;
import com.rabbit.samples.springrediscache.services.PostService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 06 Feb 2019
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Getter(value = AccessLevel.PROTECTED)
@Service
public class PostServiceImpl implements PostService {

	PostRepo postRepo;

	@Override
	public List<Post> getAll() {

		return IteratorUtils.toList(
				getPostRepo().findAll().iterator()
		);
	}

	@Override
	public Post getById(final Long id) {

		return getPostRepo()
				.findById(id)
				.orElse(
						getErrorPost("No Post found with ID" + id)
				);
	}

	@Override
	public Post insert(final Post post) {

		return save(post);
	}

	@Override
	public Post update(final Post post) {

		return save(post);
	}

	@Override
	public void deleteAll() {

		getPostRepo().deleteAll();
	}

	@Override
	public void deleteById(final Long id) {

		getPostRepo().deleteById(id);
	}

	protected Post save(final Post post) {

		return getPostRepo().save(post);
	}

	@Override
	public Post getErrorPost(final String errMsg) {

		return Post.builder().errMsg(errMsg).build();
	}

}
