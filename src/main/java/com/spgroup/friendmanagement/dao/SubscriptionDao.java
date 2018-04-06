package com.spgroup.friendmanagement.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spgroup.friendmanagement.eo.Subscription;


@Repository
public interface SubscriptionDao extends JpaRepository<Subscription, Subscription.SubscribePk> {

    @Query("select s.requestor.email"
            + " from Subscription s"
            + " join s.requestor r"
            + " join s.target t"
            + " where t.email = ?1")
    List<String> findAllRequestorEmailsByEmailTarget(String emailTarget);

}
