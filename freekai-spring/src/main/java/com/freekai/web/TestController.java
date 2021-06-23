package com.freekai.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/test/{msg}")
	public String test(@PathVariable("msg") String msg){
		return "hello mvc test, " + msg;
	}
}
