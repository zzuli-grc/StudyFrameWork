package com.study.mapper;

import com.study.domain.Role;

import java.util.List;

public interface RoleDao {
    List<Role> findAll();

    void save(Role role);

    List<Role> findRoleById(Long id);
}
