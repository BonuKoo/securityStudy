package com.study.security.users.service;

import com.study.security.admin.repository.RoleRepository;
import com.study.security.domain.entity.Account;
import com.study.security.domain.entity.Role;
import com.study.security.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    @Transactional
    public void createUser(Account account){

        Role role = roleRepository.findByRoleName("ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);

        account.setUserRoles(roles);
        userRepository.save(account);

    }

}
