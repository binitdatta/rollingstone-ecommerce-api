package com.rollingstone.service.event;

import org.springframework.context.ApplicationEvent;

import com.rollingstone.domain.Account;

/**
 * This is an optional class used in publishing application events. This can be
 * used to inject events into the Spring Boot audit management endpoint.
 */
public class CategoryServiceEvent extends ApplicationEvent {
	
	Account eventAccount;
	String eventType;
	
	public CategoryServiceEvent(Object source) {
		super(source);
	}

	public String toString() {
		return "My AccountService Event";
	}

	
	public Account getEventAccount() {
		return eventAccount;
	}

	public void setEventAccount(Account eventAccount) {
		this.eventAccount = eventAccount;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public CategoryServiceEvent(Object source, Account eventAccount, String eventType) {
		super(source);
		this.eventAccount = eventAccount;
		this.eventType = eventType;
	}
	
	
}