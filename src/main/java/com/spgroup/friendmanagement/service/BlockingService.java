package com.spgroup.friendmanagement.service;

import java.util.List;

import com.spgroup.friendmanagement.eo.Blocking;

public interface BlockingService {

    Blocking block(String emailTarget, String emailRequestor) throws Exception;

    boolean isBlocked(String emailTarget, String emailRequestor) throws Exception;

    List<String> getAllEmailsWhichAreBlockingTheEmailTarget(String emailRequestor);
}
