package com.wipro.rabbitmq;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.wipro.model.StudentSubscriptionDto;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping(value = "/rabbitmq")
public class RabbitMqController {


	@Autowired
	RabbitMqSender rabbitMQSender;

	@Autowired
	private RestTemplate resttemplate;

	@PostMapping(value = "/producer")
	public String producer(@RequestBody StudentSubscriptionDto stus) {

		rabbitMQSender.send(stus);

		return "Message sent to the RabbitMQ Successfully";
	}

	@GetMapping("/getallsports")
	@CircuitBreaker(name = "sportsService", fallbackMethod = "subscribesFallbackMethod")
	@SuppressWarnings("unchecked")
	public ResponseEntity<String> getAllSports() {
		List<String> sportslist = resttemplate.getForObject("http://localhost:9099/sports", List.class);
		System.out.println("resttemplate output");
		System.out.println(sportslist.toString());
		return ResponseEntity.ok(sportslist.toString());
	}

	public ResponseEntity<String> subscribesFallbackMethod(RuntimeException e) {
		return ResponseEntity.ok("Sports subscribe service is down");
				
	}

}


