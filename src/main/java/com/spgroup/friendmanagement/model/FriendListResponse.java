package com.spgroup.friendmanagement.model;

import java.util.List;

public class FriendListResponse extends SPGroupBaseResponse {

	
    public FriendListResponse(List<String> friends) {
		super();
		this.friends = friends;
	}

	private List<String> friends;

    public int getCount() {
        return friends == null ? 0 : friends.size();
    }

	public List<String> getFriends() {
		return friends;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}
    
    
}
