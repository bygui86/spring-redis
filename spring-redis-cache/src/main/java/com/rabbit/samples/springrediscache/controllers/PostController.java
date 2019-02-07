package com.rabbit.samples.springrediscache.controllers;

import com.rabbit.samples.springrediscache.domain.Post;
import com.rabbit.samples.springrediscache.services.PostService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 04 Feb 2019
 */
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter(value = AccessLevel.PROTECTED)
@RestController
@RequestMapping("/posts")
public class PostController {

	static final String ALL_CACHE = "post-all";

	static final String SINGLE_CACHE = "post-single";

	final PostService postService;

	@Cacheable(value = ALL_CACHE)
	@GetMapping
	public List<Post> getAll() {

		log.info("Get all Posts");

		return getPostService().getAll();
	}

	@Cacheable(value = SINGLE_CACHE, key = "#id", unless = "#result.shares < 500")
	@GetMapping("/{id}")
	public Post getById(@PathVariable final Long id) {

		if (id == null && id <= 0) {
			log.error("Get Post by id: ID must be positive!");
			return getPostService().getErrorPost("ID must be positive");
		}

		log.info("Get Post by id {}", id);

		return getPostService().getById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Post insert(@RequestBody @Valid final Post post) {

		if (post == null) {
			log.error("Insert Post: Object can not be null!");
			return getPostService().getErrorPost("Object can not be null");
		}

		log.info("Insert Post {}", post);

		return getPostService().insert(post);
	}

	@CachePut(value = SINGLE_CACHE, key = "#post.id")
	@PutMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Post update(@RequestBody @Valid final Post post) {

		if (post == null) {
			log.error("Update Post: Object can not be null!");
			return getPostService().getErrorPost("Object can not be null");
		}

		log.info("Update Post {}", post);

		return getPostService().update(post);
	}

	@CacheEvict(value = ALL_CACHE, allEntries = true)
	@DeleteMapping
	public void deleteAll() {

		log.info("Delete all Posts");

		getPostService().deleteAll();
	}

	@CacheEvict(value = SINGLE_CACHE, key = "#id")
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable final Long id) {

		if (id == null && id <= 0) {
			log.error("Delete Post by id: ID must be positive!");
		}

		log.info("Delete Post by id {}", id);

		getPostService().deleteById(id);
	}

}
