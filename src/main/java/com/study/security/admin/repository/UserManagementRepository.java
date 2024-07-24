package com.study.security.admin.repository;

import com.study.security.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserManagementRepository extends JpaRepository<Account,Long> {
}
