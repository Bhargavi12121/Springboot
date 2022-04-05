package com.wipro.rabbitmq;

import java.util.List;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wipro.model.StudentSubscriptionDto;

@Service
public class RabbitMqSender {
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	

	@Value("${rabbitmq.exchange}")
	private String exchange;
	
	@Value("${rabbitmq.routingkey}")
	private String routingkey;	
	
	
	public void send(StudentSubscriptionDto stus) {
		
		
		rabbitTemplate.convertAndSend(exchange, routingkey, stus);
		System.out.println("Send msg = " + stus);
	    
	}
	
}
