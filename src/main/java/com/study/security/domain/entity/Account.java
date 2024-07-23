package com.study.security.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Account implements Serializable {
    @Id @GeneratedValue
    private Long id;
    @Column
    private String username;
    @Column
    private int age;
    @Column
    private String password;

    //TODO 중간 테이블 직접 만들어라
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @JoinTable(name = "account_roles",
            joinColumns = {@JoinColumn(name = "account_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")} )
    @ToString.Exclude
    private Set<Role> userRoles = new HashSet<>();

}
