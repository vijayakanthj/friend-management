package com.spgroup.friendmanagement.service;

import java.util.List;

import com.spgroup.friendmanagement.eo.Subscription;



public interface SubscriptionService {

    Subscription subscribe(String emailTarget, String emailRequestor) throws Exception;

    List<String> retrieveSubscribers(String email);

}
