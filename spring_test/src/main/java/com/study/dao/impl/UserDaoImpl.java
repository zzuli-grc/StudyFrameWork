package com.study.dao.impl;

import com.study.dao.UserDao;
import com.study.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 查询用户信息
     *
     * @return
     */
    @Override
    public List<User> list() {
        return jdbcTemplate.query("select * from sys_user", new BeanPropertyRowMapper<>(User.class));
    }

    /**
     * 保存用户
     *
     * @param user
     */
    @Override
    public Long save(User user) {
        //创建PreparedStatementCreator
        PreparedStatementCreator creator = con -> {
            PreparedStatement preparedStatement = con.prepareStatement("insert into sys_user values (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setObject(1, null);
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getPhoneNum());
            return preparedStatement;
        };
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(creator, keyHolder);
        long userId = Objects.requireNonNull(keyHolder.getKey()).longValue();
        return userId;
    }

    /**
     * 保存用户和角色关系
     *
     * @param userId
     * @param roleIds
     */
    @Override
    public void saveUserRoleRel(Long userId, Long[] roleIds) {
        for (Long roleId : roleIds) {
            jdbcTemplate.update("insert into sys_user_role values (?,?)", userId, roleId);
        }
    }

    /**
     * 删除用户和角色的关联表信息
     *
     * @param userId
     */
    @Override
    public void delUserRole(String userId) {
        jdbcTemplate.update("delete from sys_user_role where userId=?", userId);
    }

    /**
     * 删除用户信息
     *
     * @param userId
     */
    @Override
    public void del(String userId) {
        jdbcTemplate.update("delete from sys_user where id=?", userId);
    }
}
