package com.spgroup.friendmanagement.service;

import java.util.List;


public interface FriendService {
	void createFriendConnection(String email1, String email2) throws Exception ;

    List<String> retrieveFriends(String email) throws Exception ;

    List<String> retrieveCommonFriends(String email1, String email2) throws Exception ;
}
