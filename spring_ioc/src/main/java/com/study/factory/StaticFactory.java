package com.study.factory;

import com.study.mapper.UserDao;
import com.study.mapper.impl.UserDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zzuli_grc
 */
public class StaticFactory {
    public static UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
