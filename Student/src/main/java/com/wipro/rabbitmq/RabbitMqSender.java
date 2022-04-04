package com.wipro.rabbitmq;

import java.util.List;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wipro.model.StudentSubscriptionDto;

@Service
public class RabbitMqSender {
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Autowired
	private RestTemplate resttemplate;
	
	@Value("${rabbitmq.exchange}")
	private String exchange;
	
	@Value("${rabbitmq.routingkey}")
	private String routingkey;	
	
	@SuppressWarnings("unchecked")
	public void send(StudentSubscriptionDto stus) {
		
		List<String> sportslist=resttemplate.getForObject("http://localhost:9099/sports", List.class);
		System.out.println("resttemplate output");
		System.out.println(sportslist);
		rabbitTemplate.convertAndSend(exchange, routingkey, stus);
		System.out.println("Send msg = " + stus);
	    
	}
}
