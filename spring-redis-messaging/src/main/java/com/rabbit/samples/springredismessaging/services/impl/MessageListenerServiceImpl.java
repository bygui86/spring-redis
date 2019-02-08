package com.rabbit.samples.springredismessaging.services.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


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
public class MessageListenerServiceImpl implements MessageListener {

	List<String> messageList = new ArrayList<>();

	@Override
	public void onMessage(final Message message, final byte[] pattern) {

		getMessageList().add(message.toString());

		log.info("Message received on channel '{}': {}",
				new String(message.getChannel()),
				message.toString());
	}

}
