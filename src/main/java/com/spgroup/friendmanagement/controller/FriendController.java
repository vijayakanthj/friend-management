package com.spgroup.friendmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spgroup.friendmanagement.model.FriendRequest;
import com.spgroup.friendmanagement.model.SPGroupBaseResponse;
import com.spgroup.friendmanagement.service.BlockingService;
import com.spgroup.friendmanagement.service.FriendService;
import com.spgroup.friendmanagement.service.SubscriptionService;

@RestController
@RequestMapping("/friend")
public class FriendController {

	@Autowired
	private FriendService friendService;

	@Autowired
	private SubscriptionService subscriptionService;
	
	@Autowired
	private BlockingService blockingService;

	
	@RequestMapping(value = "/connect", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public SPGroupBaseResponse connect(@RequestBody FriendRequest friendRequest) throws Exception {
		friendService.createFriendConnection(friendRequest.getEmail1(), friendRequest.getEmail2());		
		return new  SPGroupBaseResponse();
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public SPGroupBaseResponse retrieveFriends(@RequestBody FriendRequest friendRequest) throws Exception {
		friendService.retrieveFriends(friendRequest.getEmail1());		
		return new  SPGroupBaseResponse();
	}

	
	@RequestMapping(value = "/common", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public SPGroupBaseResponse retrieveCommonFriends(@RequestBody FriendRequest friendRequest) throws Exception {
		friendService.retrieveCommonFriends(friendRequest.getEmail1(), friendRequest.getEmail2());		
		return new  SPGroupBaseResponse();
	}

	
	@RequestMapping(value = "/subscribe", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public SPGroupBaseResponse subscribe(@RequestBody FriendRequest friendRequest) throws Exception {
		subscriptionService.subscribe(friendRequest.getEmail1(), friendRequest.getEmail2());		
		return new  SPGroupBaseResponse();
	}

	
	@RequestMapping(value = "/block", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public SPGroupBaseResponse block(@RequestBody FriendRequest friendRequest) throws Exception {
		blockingService.block(friendRequest.getEmail1(), friendRequest.getEmail2());		
		return new  SPGroupBaseResponse();
	}


	
	

}
