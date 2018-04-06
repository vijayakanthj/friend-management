package com.spgroup.friendmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spgroup.friendmanagement.model.PersonRequest;
import com.spgroup.friendmanagement.model.SPGroupBaseResponse;
import com.spgroup.friendmanagement.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public SPGroupBaseResponse register(@RequestBody PersonRequest request) throws Exception {
		personService.register(request.getEmail());		
		return new  SPGroupBaseResponse();
	}
}
