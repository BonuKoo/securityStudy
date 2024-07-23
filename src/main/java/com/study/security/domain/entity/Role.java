package com.study.security.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@RestController
@Entity
public class Role {
    @Column(name = "role_id")
    @Id @GeneratedValue
    private Long id;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "role_desc")
    private String roleDesc;

    @Column(name = "is_expression")
    private String isExpression;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "roleSet",cascade = CascadeType.ALL)
    @OrderBy("orderNum desc")
    private Set<Resources> resourcesSet = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "userRoles", cascade = CascadeType.ALL)
    private Set<Account> accounts = new HashSet<>();
}
