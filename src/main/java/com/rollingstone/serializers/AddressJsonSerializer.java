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
import com.rollingstone.domain.Address;

//@JsonComponent
public class AddressJsonSerializer extends JsonSerializer<Address> {

	Logger logger  = LoggerFactory.getLogger("AccountJsonSerializer");

	@Override
    public void serialize(Address address, JsonGenerator jsonGenerator, 
      SerializerProvider serializerProvider) throws IOException, 
      JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		logger.info("AddressJsonSerializer...........");
		
		if (address.getAccount() == null) {
			logger.info("AddressJsonSerializer........... account null");
		}
		else {
			logger.info("AddressJsonSerializer........... account not null");
		}
		
		 jsonGenerator.writeStartObject();
		 jsonGenerator.writeNumberField("id", address.getId());
		 jsonGenerator.writeStringField("houseNumber", address.getHouseNumber());
		 jsonGenerator.writeStringField("streetAddress", address.getStreetAddress());
		 jsonGenerator.writeStringField("city", address.getCity());
		 jsonGenerator.writeStringField("state", address.getState());
		 jsonGenerator.writeStringField("zipCode", address.getZipCode());
		 jsonGenerator.writeNumberField("accountId", address.getAccount().getId());
		 jsonGenerator.writeStringField("accountName", address.getAccount().getAccountName());
	}
}
