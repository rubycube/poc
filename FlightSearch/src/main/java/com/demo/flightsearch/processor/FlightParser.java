package com.demo.flightsearch.processor;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.codehaus.jackson.map.ObjectMapper;

import com.demo.flightsearch.model.Products;



public class FlightParser implements Processor{
	
	@Override
	public void process(Exchange exchange) throws Exception {
		Map<String,Object> headers = exchange.getIn().getHeaders();
		headers.put("accept", "application/json");
		headers.put("content-type", "application/json");
		exchange.getOut().setHeaders(headers);
		exchange.getOut().setBody(null);		
	}
	
	
	
	public Products parseResult(HashMap<String, String> prodDetails){	
		final ObjectMapper mapper = new ObjectMapper(); 
		return mapper.convertValue(prodDetails, Products.class);
	}	
	

}
