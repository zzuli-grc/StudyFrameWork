package com.stuudy.Test;

import com.study.dao.UserDao;
import org.junit.Test;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocTest {
    @Test
    public void test1() {
//        初始化容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取指定的对象
        UserDao user1 = (UserDao) applicationContext.getBean("userDao");
        user1.save();
        //执行销毁方法
        ((ClassPathXmlApplicationContext) applicationContext).close();
    }
}
