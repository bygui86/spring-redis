package com.rabbit.samples.springredismessaging.configs;

import com.rabbit.samples.springredismessaging.services.impl.MessageListenerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericToStringSerializer;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 03 Feb 2019
 */
@Configuration
public class RedisConfig {

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
		template.setValueSerializer(new GenericToStringSerializer<>(Object.class));
		return template;
	}

	@Bean
	MessageListener messageListenerService() {

		return new MessageListenerServiceImpl();
	}

	@Bean
	MessageListenerAdapter messageListenerAdapter() {

		return new MessageListenerAdapter(messageListenerService());
	}

	@Bean
	ChannelTopic channelTopic() {

		return new ChannelTopic("redis-pubsub");
	}

	@Bean
	RedisMessageListenerContainer redisMessageListenerContainer() {

		final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(jedisConnectionFactory());
		container.addMessageListener(messageListenerAdapter(), channelTopic());
		return container;
	}

}
