package com.spgroup.friendmanagement.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spgroup.friendmanagement.eo.Blocking;


@Repository
public interface BlockingDao extends JpaRepository<Blocking, Blocking.BlockPk> {

    @Query("select b.requestor.email"
            + " from Blocking b"
            + " join b.requestor r"
            + " join b.target t"
            + " where t.email = ?1")
    List<String> findAllRequestorEmailsByEmailTarget(String emailTarget);

}
