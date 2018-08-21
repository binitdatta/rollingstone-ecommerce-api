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
import com.rollingstone.domain.Cart;


public class CartJsonSerializer extends JsonSerializer<Cart> {

	Logger logger  = LoggerFactory.getLogger("CartJsonSerializer");
	
	@Override
    public void serialize(Cart cart, JsonGenerator jsonGenerator, 
      SerializerProvider serializerProvider) throws IOException, 
      JsonProcessingException {
		
		 jsonGenerator.writeStartObject();
		 jsonGenerator.writeNumberField("id", cart.getId());
		 jsonGenerator.writeNumberField("cartTotal", cart.getCartTotal());
		 jsonGenerator.writeStringField("cartDate", cart.getCartDate().toLocaleString());
		 jsonGenerator.writeStringField("userName", cart.getUser().getFirstName() + 
				 " "+cart.getUser().getLastName());
		 jsonGenerator.writeStringField("memberType", cart.getUser().getMemberType());
		 
		 ObjectMapper objectMapper = new ObjectMapper();
		 
		 objectMapper.writeValue(jsonGenerator, cart.getCartItems());	 
		 
		 //jsonGenerator.writeEndObject();

    }
 
   
}
