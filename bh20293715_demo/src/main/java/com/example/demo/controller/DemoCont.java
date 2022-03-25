package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoCont {
	
	@RequestMapping("/home")
	public String request() {
		return ("Docker demo home page");
	}

	@RequestMapping("/login")
	public String requestLogin() {
		return ("Docker demo login page");
	}
	
//	@Value( "${server.port}" )
//	private String server;
	
}
