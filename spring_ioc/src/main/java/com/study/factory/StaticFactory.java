package com.study.factory;

import com.study.mapper.UserDao;
import com.study.mapper.impl.UserDaoImpl;

public class StaticFactory {
    public static UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
