package com.java.mail.javamail.repository;

import com.java.mail.javamail.domain.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<EmailEntity, Long> {

    @Query("select e from EmailEntity e where e.statusEmail = 1")
    List<EmailEntity> findEmailEntityByStatus();
}
