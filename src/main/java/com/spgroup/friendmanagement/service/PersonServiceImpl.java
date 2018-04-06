package com.spgroup.friendmanagement.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spgroup.friendmanagement.dao.PersonDao;
import com.spgroup.friendmanagement.eo.Person;




@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    @Transactional
    public Person register(String email) throws Exception {
        if (personDao.existsByEmail(email)) {
            throw new Exception("Email Already Registered");
        }
        return personDao.save(new Person(email));
    }

    @Override
    public Person findByEmailOrThrowEmailNotRegisteredApiException(String email) throws Exception {
        Person p = personDao.findByEmail(email);
        if (p == null) {
            throw new Exception("Email Not Registered");
        }
        return p;
    }
}
