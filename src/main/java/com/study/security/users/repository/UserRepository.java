package com.study.security.users.repository;

import com.study.security.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Account,Long> {

    Account findByUsername(String username);

}
