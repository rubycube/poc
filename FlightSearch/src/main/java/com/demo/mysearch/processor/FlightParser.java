package com.demo.mysearch.processor;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.demo.mysearch.model.Posts;
import com.demo.mysearch.model.Response;
import com.demo.mysearch.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FlightParser implements Processor{
	
	@Override
	public void process(Exchange exchange) throws Exception {
		Map<String,Object> headers = exchange.getIn().getHeaders();
		final ObjectMapper mapper = new ObjectMapper(); 
		final Posts[]  prodInfo = mapper.convertValue(exchange.getIn().getBody(), Posts[].class);
		headers.put("result1", prodInfo);
		exchange.getOut().setHeaders(headers);
		exchange.getOut().setBody(null);		
	}
	
	
	
	public Response parseResult(HashMap<String, String> result2, Posts[] posts){	
		final ObjectMapper mapper = new ObjectMapper(); 
		final User user = mapper.convertValue(result2, User.class);
		Response response = new Response();
		response.setUser(user);
		response.setPosts(posts);
		return response;
	}	
	

}
