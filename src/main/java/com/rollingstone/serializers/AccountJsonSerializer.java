package com.rollingstone.serializers;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.rollingstone.domain.Account;

//@JsonComponent
public class AccountJsonSerializer extends JsonSerializer<Account> {

	Logger logger  = LoggerFactory.getLogger("AccountJsonSerializer");

	@Override
    public void serialize(Account account, JsonGenerator jsonGenerator, 
      SerializerProvider serializerProvider) throws IOException, 
      JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		logger.info("AccountJsonSerializer...........");
		
		 jsonGenerator.writeStartObject();
		 jsonGenerator.writeNumberField("id", account.getId());
		 jsonGenerator.writeStringField("accountName", account.getAccountName());
		 jsonGenerator.writeEndObject();

	
    }
} 