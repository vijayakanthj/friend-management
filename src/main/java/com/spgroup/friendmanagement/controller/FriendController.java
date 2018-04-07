package com.spgroup.friendmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.errorprone.annotations.concurrent.UnlockMethod;
import com.spgroup.friendmanagement.model.FriendListRequest;
import com.spgroup.friendmanagement.model.FriendListResponse;
import com.spgroup.friendmanagement.model.FriendRequest;
import com.spgroup.friendmanagement.model.FriendSubscribeRequest;
import com.spgroup.friendmanagement.model.FriendUpdatesRequest;
import com.spgroup.friendmanagement.model.FriendUpdatesResponse;
import com.spgroup.friendmanagement.model.SPGroupBaseResponse;
import com.spgroup.friendmanagement.service.BlockingService;
import com.spgroup.friendmanagement.service.FriendService;
import com.spgroup.friendmanagement.service.SubscriptionService;
import com.spgroup.friendmanagement.service.UpdatesService;

@RestController
@RequestMapping("/friend")
public class FriendController {

	@Autowired
	private FriendService friendService;

	@Autowired
	private SubscriptionService subscriptionService;
	
	@Autowired
	private BlockingService blockingService;
	
	@Autowired
	private UpdatesService updateService;

	
	@RequestMapping(value = "/connect", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public SPGroupBaseResponse connect(@RequestBody FriendRequest friendRequest) throws Exception {
		friendService.createFriendConnection(friendRequest.getEmail1(), friendRequest.getEmail2());		
		return new  SPGroupBaseResponse();
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public SPGroupBaseResponse retrieveFriends(@RequestBody FriendListRequest friendListRequest) throws Exception {
		List<String> friends=friendService.retrieveFriends(friendListRequest.getEmail());		
		return new  FriendListResponse(friends);
	}

	
	@RequestMapping(value = "/common", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public SPGroupBaseResponse retrieveCommonFriends(@RequestBody FriendRequest friendRequest) throws Exception {
		List<String> commonFriends=friendService.retrieveCommonFriends(friendRequest.getEmail1(), friendRequest.getEmail2());		
		return new  FriendListResponse(commonFriends);
	}

	
	@RequestMapping(value = "/subscribe", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public SPGroupBaseResponse subscribe(@RequestBody FriendSubscribeRequest subscribeRequest) throws Exception {
		subscriptionService.subscribe(subscribeRequest.getRequestor(), subscribeRequest.getTarget());		
		return new  SPGroupBaseResponse();
	}

	
	@RequestMapping(value = "/block", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public SPGroupBaseResponse block(@RequestBody FriendSubscribeRequest friendRequest) throws Exception {
		blockingService.block(friendRequest.getRequestor(), friendRequest.getTarget());		
		return new  SPGroupBaseResponse();
	}


	@RequestMapping(value = "/updates", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public SPGroupBaseResponse block(@RequestBody FriendUpdatesRequest updateRequest) throws Exception {		
		List<String> receipients=updateService.retrieveAllRecipients(updateRequest.getSender(), updateRequest.getText());
		return new FriendUpdatesResponse(receipients);
	}
	
	

}
