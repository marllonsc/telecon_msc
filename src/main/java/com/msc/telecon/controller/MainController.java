package com.msc.telecon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msc.telecon.component.ProducerMq;
import com.msc.telecon.entity.Request;

@RestController
@RequestMapping("/main")
public class MainController {
	
	@Autowired
	private ProducerMq producer;
	

	@RequestMapping(value = "/request", method = RequestMethod.POST, consumes = "application/json")
	public Request sendRequest(@RequestBody Request request) {
		return producer.sendMessage("requests", request);
	}
	

}
