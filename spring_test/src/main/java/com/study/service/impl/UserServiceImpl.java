package com.study.service.impl;

import com.study.dao.RoleDao;
import com.study.dao.UserDao;
import com.study.domain.Role;
import com.study.domain.User;
import com.study.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private RoleDao roleDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    /**
     * 查询用户信息
     *
     * @return
     */
    @Override
    public List<User> list() {
        List<User> userList = userDao.list();
        for (User user : userList) {
            Long id = user.getId();
            List<Role> roleList = roleDao.findRoleById(id);
            user.setRoles(roleList);
        }
        return userList;
    }

    /**
     * 添加用户
     *
     * @param user
     * @param roleIds
     */
    @Override
    public void save(User user, Long[] roleIds) {
        //存储用户信息
        Long userId = userDao.save(user);
        //存储用户和角色对应关系
        userDao.saveUserRoleRel(userId, roleIds);
    }

    /**
     * 删除用户
     *
     * @param userId
     */
    @Override
    public void del(String userId) {
        //删除用户和角色关系
        userDao.delUserRole(userId);
        //删除用户
        userDao.del(userId);
    }
}
