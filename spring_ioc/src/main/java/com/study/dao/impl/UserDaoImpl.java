package com.study.dao.impl;

import com.study.dao.UserDao;

public class UserDaoImpl implements UserDao {
    public UserDaoImpl() {
        System.out.println("对象创建....");
    }

    public void save() {
        System.out.println("save方法调用了");
    }

    public void init() {
        System.out.println("初始化方法执行....");
    }

    public void destroy() {
        System.out.println("销毁方法执行了....");
    }
}
