package com.spgroup.friendmanagement.model;

import java.util.List;

public class FriendUpdatesResponse extends SPGroupBaseResponse {

	
	
	public FriendUpdatesResponse(List<String> recipients) {
		super();
		this.recipients = recipients;
	}

	private List<String> recipients;

	public List<String> getRecipients() {
		return recipients;
	}

	public void setRecipients(List<String> recipients) {
		this.recipients = recipients;
	}

	
	
}
