package com.study.dao;

import com.study.domain.User;

import java.util.List;

public interface UserDao {
    List<User> list();

    Long save(User user);

    void saveUserRoleRel(Long id, Long[] roleIds);

    void delUserRole(String userId);

    void del(String userId);

}
