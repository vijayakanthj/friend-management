package com.spgroup.friendmanagement.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spgroup.friendmanagement.dao.PersonDao;
import com.spgroup.friendmanagement.validation.FriendValidation;

@Service
public class UpdatesServiceImpl implements UpdatesService {

    @Autowired
    private PersonDao personDao;
    @Autowired
    private FriendService friendService;
    @Autowired
    private BlockingService blockingService;
    @Autowired
    private SubscriptionService subscriptionService;
    @Autowired
    private FriendValidation friendValidation;

    @Override
    public List<String> retrieveAllRecipients(String sender, String text) throws Exception {
        Set<String> set = new HashSet();
        // add all connected friends
        List<String> friends = friendService.retrieveFriends(sender);
        set.addAll(friends);
        // add all subscribers
        List<String> subscribers = subscriptionService.retrieveSubscribers(sender);
        set.addAll(subscribers);
        // add all mentions
        Set<String> mentions = findMentionsEmail(text);
        mentions.stream()
                .filter(personDao::existsByEmail)
                .forEach(set::add);
        // exclude all blocks
        List<String> blocks = blockingService.getAllEmailsWhichAreBlockingTheEmailTarget(sender);
        set.removeAll(blocks);

        return new ArrayList(set);
    }

    private Set<String> findMentionsEmail(String text) {
        Matcher m = friendValidation.getEmailPattern().matcher(text);
        Set<String> set = new LinkedHashSet<>();
        while (m.find()) {
            set.add(m.group());
        }
        return set;
    }

}
