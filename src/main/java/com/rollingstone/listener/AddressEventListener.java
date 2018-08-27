package com.rollingstone.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.rollingstone.service.event.AddressServiceEvent;

@Component
public class AddressEventListener implements ApplicationListener<AddressServiceEvent> {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@EventListener
	public void onApplicationEvent(AddressServiceEvent event) {
		AddressServiceEvent addressEvent = (AddressServiceEvent) event;
		logger.info("Address Event Listener " + event.getEventType() + " with details : " 
		+ event.getEventAddress().toString());
	}
}