package com.rabbit.samples.springredismessaging.configs;

import com.rabbit.samples.springredismessaging.services.MessagePublisherService;
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
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter(value = AccessLevel.PROTECTED)
@Configuration
@EnableScheduling
public class SchedulingConfig {

	static final int PUBLISH_INTERVAL = 3000;

	static final String MESSAGE_PREFIX = "Message sent through Redis - number ";

	static int COUNTER = 0;

	final MessagePublisherService messagePublisherService;

	@Scheduled(fixedRate = PUBLISH_INTERVAL)
	void publishMessage() {

		final String message = MESSAGE_PREFIX + COUNTER;

		getMessagePublisherService().publish(message);

		COUNTER++;
	}

}
