package com.wipro.spa;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpaController {
	
	@GetMapping("/sports")
	public List<String> getAllSports(){
		return Arrays.asList("Tennis","Baseball","Volleyball","Golf","Badminton","kabaddi");
	}

}
