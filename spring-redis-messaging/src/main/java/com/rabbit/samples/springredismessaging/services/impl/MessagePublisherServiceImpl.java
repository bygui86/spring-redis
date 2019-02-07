package com.rabbit.samples.springredismessaging.services.impl;

import com.rabbit.samples.springredismessaging.services.MessagePublisherService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 07 Feb 2019
 */
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Getter(value = AccessLevel.PROTECTED)
@Service
public class MessagePublisherServiceImpl implements MessagePublisherService {

	RedisTemplate<String, Object> redisTemplate;

	ChannelTopic channelTopic;

	@Override
	public void publish(final String message) {

		log.info("Sending message: {}", message);

		getRedisTemplate()
				.convertAndSend(
						getChannelTopic().getTopic(),
						message
				);
	}

}
