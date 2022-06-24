package com.thomasjazz.contactmanager.repository;

import com.thomasjazz.contactmanager.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {}
