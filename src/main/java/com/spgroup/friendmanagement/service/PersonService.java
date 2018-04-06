package com.spgroup.friendmanagement.service;

import com.spgroup.friendmanagement.eo.Person;


public interface PersonService {

    Person register(String email) throws Exception;

    Person findByEmailOrThrowEmailNotRegisteredApiException(String email) throws Exception;
}
