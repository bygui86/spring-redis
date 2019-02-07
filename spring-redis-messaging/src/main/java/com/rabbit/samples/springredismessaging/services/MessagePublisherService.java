package com.rabbit.samples.springredismessaging.services;

/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 07 Feb 2019
 */
public interface MessagePublisherService {

	void publish(final String message);

}
