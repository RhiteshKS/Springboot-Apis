package com.example.demo;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SuppressWarnings("deprecation")
@EnableBinding(Sink.class)
public class MessageConsumer {
	@StreamListener(Sink.INPUT)
	public void log(Transaction msg) {
		System.out.println("Message contains orderId as"+msg.getOrderId());
	}
	

}
