package com.rollingstone.service.event;

import org.springframework.context.ApplicationEvent;

import com.rollingstone.domain.Account;
import com.rollingstone.domain.Address;

/**
 * This is an optional class used in publishing application events. This can be
 * used to inject events into the Spring Boot audit management endpoint.
 */
public class AddressServiceEvent extends ApplicationEvent {
	
	Address eventAddress;
	String eventType;
	
	public AddressServiceEvent(Object source) {
		super(source);
	}

	public String toString() {
		return "My AccountService Event";
	}

	


	public Address getEventAddress() {
		return eventAddress;
	}

	public void setEventAddress(Address eventAddress) {
		this.eventAddress = eventAddress;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public AddressServiceEvent(Object source, Address eventAddress, String eventType) {
		super(source);
		this.eventAddress = eventAddress;
		this.eventType = eventType;
	}
	
	
}