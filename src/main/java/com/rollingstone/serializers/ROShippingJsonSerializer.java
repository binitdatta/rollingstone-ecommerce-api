package com.rollingstone.serializers;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.rollingstone.domain.ROShipping;


public class ROShippingJsonSerializer extends JsonSerializer<ROShipping> {

	Logger logger  = LoggerFactory.getLogger("ShippingJsonSerializer");
	
	@Override
    public void serialize(ROShipping shipping, JsonGenerator jsonGenerator, 
      SerializerProvider serializerProvider) throws IOException, 
      JsonProcessingException {
		
		logger.info("inside ShippingJsonSerializer");
		 jsonGenerator.writeStartObject();
		 jsonGenerator.writeNumberField("id", shipping.getId());
		 jsonGenerator.writeNumberField("offerId", shipping.getOfferId());

		 jsonGenerator.writeBooleanField("isAvailable", shipping.isAvailable());
		 jsonGenerator.writeStringField("availableDate", shipping.getAvailableDate().toLocaleString());
		 jsonGenerator.writeBooleanField("isFree", shipping.isFree());
		 jsonGenerator.writeBooleanField("isFree", shipping.isFree());

		 jsonGenerator.writeNumberField("daysInTransit", shipping.getDaysInTransit());

		 jsonGenerator.writeNumberField("shippingCharge", shipping.getShippingCharge());
		 jsonGenerator.writeBooleanField("isFreeShippingForMembers", shipping.isFreeShippingForMembers());
		 jsonGenerator.writeStringField("shippingMode", shipping.getShippingMode());
		 jsonGenerator.writeStringField("shipCarrier", shipping.getShipCarrier());
		 jsonGenerator.writeStringField("orderNumber", shipping.getOrderNumber());

		 
		 ObjectMapper objectMapper = new ObjectMapper();
		 
		 objectMapper.writeValue(jsonGenerator, shipping.getShippingItems());	 
		 
		 //jsonGenerator.writeEndObject();

    }


 
   
}

