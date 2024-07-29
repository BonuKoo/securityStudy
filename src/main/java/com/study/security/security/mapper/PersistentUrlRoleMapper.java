package com.study.security.security.mapper;

import com.study.security.admin.repository.ResourcesRepository;
import com.study.security.domain.entity.Resources;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PersistentUrlRoleMapper implements UrlRoleMapper{


    private final LinkedHashMap<String,String> urlRoleMappings = new LinkedHashMap<>();
    private final ResourcesRepository resourcesRepository;

    public PersistentUrlRoleMapper(ResourcesRepository resourcesRepository) {
        this.resourcesRepository = resourcesRepository;
    }

    @Override
    public Map<String, String> getUrlRoleMappings() {
        List<Resources> resourcesList = resourcesRepository.findAllResources();
        resourcesList.forEach(re-> {

            re.getRoleSet().forEach(role ->
                    urlRoleMappings.put(re.getResourceName(),role.getRoleName()));

        });

        return urlRoleMappings;
    }
}
