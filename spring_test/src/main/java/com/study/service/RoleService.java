package com.study.service;

import com.study.domain.Role;

import java.util.List;

/**
 * service层接口
 */
public interface RoleService {
    public List<Role> list();

    void save(Role role);
}
