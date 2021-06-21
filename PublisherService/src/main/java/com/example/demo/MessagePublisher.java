package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@SuppressWarnings("deprecation")
@RestController
@EnableBinding(Source.class)
public class MessagePublisher {
	
	@Autowired
	Source source;
	
	@PostMapping(value="/txn")
	public String sendMessage(@RequestBody String payload) {
		ObjectMapper ob = new ObjectMapper();
		Transaction txn = null;
		try {
			txn = ob.readValue(payload, Transaction.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		source.output().send(MessageBuilder.withPayload(txn).setHeader("myheader", "myheaderValue").build());
		System.out.println("Successfully sent to rabbitmq");
		return "success";
	}
	

}
