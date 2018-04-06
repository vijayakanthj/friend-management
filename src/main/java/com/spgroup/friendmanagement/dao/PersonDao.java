package com.spgroup.friendmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spgroup.friendmanagement.eo.Person;


@Repository
public interface PersonDao extends JpaRepository<Person, Long> {

    Person findByEmail(String email);

    boolean existsByEmail(String email);
}

