package com.study.mybatis;

import com.study.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void test1() throws IOException {
        //加载核心配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapperConfig.xml");
        //获得session工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        List<User> userList = sqlSession.selectList("userMapper.findAll");
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
