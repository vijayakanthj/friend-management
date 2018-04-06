package com.spgroup.friendmanagement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.spgroup.friendmanagement.dao.SubscriptionDao;
import com.spgroup.friendmanagement.eo.Subscription;


@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionDao subscriptionDao;
    @Autowired
    private PersonService personService;

    @Override
    public Subscription subscribe(String emailTarget, String emailRequestor) throws Exception {
        Subscription subs = new Subscription();
        subs.setTarget(personService.findByEmailOrThrowEmailNotRegisteredApiException(emailTarget));
        subs.setRequestor(personService.findByEmailOrThrowEmailNotRegisteredApiException(emailRequestor));
        if (subscriptionDao.exists(Example.of(subs))) {
            throw new Exception("Subscription already available");
        }
        return subscriptionDao.save(subs);
    }

    @Override
    public List<String> retrieveSubscribers(String email) {
        return subscriptionDao.findAllRequestorEmailsByEmailTarget(email);
    }

}
