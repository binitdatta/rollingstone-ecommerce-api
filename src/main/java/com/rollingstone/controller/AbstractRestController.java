package com.rollingstone.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.rollingstone.domain.exceptions.HTTP400Exception;
import com.rollingstone.domain.exceptions.HTTP404Exception;
import com.rollingstone.domain.exceptions.RestAPIExceptionInfo;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;

/**
 * This class is meant to be the backbone of all other REst controllers. It
 * contains common functionality such as exception handling etc.
 */

public abstract class AbstractRestController implements ApplicationEventPublisherAware {
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	protected ApplicationEventPublisher eventPublisher;
	protected static final String DEFAULT_PAGE_SIZE = "30";
	protected static final String DEFAULT_PAGE_NUM = "0";

	
	
	Counter http400Counter = Metrics.counter("com.rollingstone.CusotmerService.HTTP400.count");
	
	Counter http404Counter = Metrics.counter("com.rollingstone.CusotmerService.HTTP404.count");

	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HTTP400Exception.class)
	public @ResponseBody RestAPIExceptionInfo handleDataStoreException(HTTP400Exception ex, WebRequest request,
			HttpServletResponse response) {
		log.info("Converting Data Store exception to RestResponse : " + ex.getMessage());
		http400Counter.increment();
		return new RestAPIExceptionInfo(ex, "The Request did not have correct parameters / body etc. Please check");
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(HTTP404Exception.class)
	public @ResponseBody RestAPIExceptionInfo handleResourceNotFoundException(HTTP404Exception ex, WebRequest request,
			HttpServletResponse response) {
		log.info("ResourceNotFoundException handler:" + ex.getMessage());
		http404Counter.increment();
		return new RestAPIExceptionInfo(ex, "The Endpoint was not found.");
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.eventPublisher = applicationEventPublisher;
	}

	public static <T> T checkResourceFound(final T resource) {
		if (resource == null) {
			throw new HTTP404Exception("resource not found");
		}
		return resource;
	}

}
