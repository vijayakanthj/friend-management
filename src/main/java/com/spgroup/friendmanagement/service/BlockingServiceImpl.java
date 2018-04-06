package com.spgroup.friendmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.spgroup.friendmanagement.dao.BlockingDao;
import com.spgroup.friendmanagement.eo.Blocking;


@Service
public class BlockingServiceImpl implements BlockingService {

    @Autowired
    private BlockingDao blockingRepo;
    @Autowired
    private PersonService personService;

    @Override
    public Blocking block(String emailTarget, String emailRequestor) throws Exception {
        Blocking blocking = new Blocking();
        blocking.setTarget(personService.findByEmailOrThrowEmailNotRegisteredApiException(emailTarget));
        blocking.setRequestor(personService.findByEmailOrThrowEmailNotRegisteredApiException(emailRequestor));
        if (blockingRepo.exists(Example.of(blocking))) {
            throw new Exception("Email already Blocked");
        }
        return blockingRepo.save(blocking);
    }

    @Override
    public boolean isBlocked(String emailTarget, String emailRequestor) throws Exception {
        Blocking blocking = new Blocking();
        blocking.setTarget(personService.findByEmailOrThrowEmailNotRegisteredApiException(emailTarget));
        blocking.setRequestor(personService.findByEmailOrThrowEmailNotRegisteredApiException(emailRequestor));
        boolean blocked = blockingRepo.exists(Example.of(blocking));
        return blocked;
    }

    /**
     * Return all emails which are blocking the emailTarget
     */
    @Override
    public List<String> getAllEmailsWhichAreBlockingTheEmailTarget(String emailTarget) {
        List<String> list = blockingRepo.findAllRequestorEmailsByEmailTarget(emailTarget);
        return list;
    }
}
