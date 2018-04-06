package com.spgroup.friendmanagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.spgroup.friendmanagement.dao.FriendDao;
import com.spgroup.friendmanagement.eo.Friend;
import com.spgroup.friendmanagement.eo.Person;



@Service
public class FriendServiceImpl implements FriendService {
	 @Autowired
	    private FriendDao friendDao;
	    @Autowired
	    private PersonService personService;
	    @Autowired
	    private BlockingService blockingService;

	    @Override
	    public void createFriendConnection(String email1, String email2) throws Exception {
	        Person p1 = personService.findByEmailOrThrowEmailNotRegisteredApiException(email1);
	        Person p2 = personService.findByEmailOrThrowEmailNotRegisteredApiException(email2);
	        Friend friend = new Friend();
	        // set lower Id to person1 and higher Id to person2
	        if (p1.getId() < p2.getId()) {
	            friend.setPerson1(p1);
	            friend.setPerson2(p2);
	        } else {
	            friend.setPerson1(p2);
	            friend.setPerson2(p1);
	        }
	        if (friendDao.exists(Example.of(friend))) {
	            throw new Exception("Friend Connection Already Exist");
	        }
	        if (blockingService.isBlocked(email1, email2) || blockingService.isBlocked(email2, email1)) {
	            throw new Exception("Blocked Friend");
	        }
	         friendDao.save(friend);
	    }

	    @Override
	    public List<String> retrieveFriends(String email) throws Exception {
	        personService.findByEmailOrThrowEmailNotRegisteredApiException(email);
	        return friendDao.findAllFriendsEmail(email);
	    }

	    @Override
	    public List<String> retrieveCommonFriends(String email1, String email2) throws Exception {
	        personService.findByEmailOrThrowEmailNotRegisteredApiException(email1);
	        personService.findByEmailOrThrowEmailNotRegisteredApiException(email2);
	        List<String> friends1 = friendDao.findAllFriendsEmail(email1);
	        List<String> friends2 = friendDao.findAllFriendsEmail(email2);
	        return friends1.stream()
	                .filter(s -> friends2.contains(s))
	                .collect(Collectors.toList());
	    }

}
