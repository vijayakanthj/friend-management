package com.spgroup.friendmanagement.service;

import java.util.List;

public interface UpdatesService {

    List<String> retrieveAllRecipients(String sender, String text) throws Exception ;

}
