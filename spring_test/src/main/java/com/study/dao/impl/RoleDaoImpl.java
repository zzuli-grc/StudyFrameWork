package com.study.dao.impl;

import com.study.dao.RoleDao;
import com.study.domain.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RoleDaoImpl implements RoleDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 查询所有角色
     *
     * @return
     */
    @Override
    public List<Role> findAll() {
        return jdbcTemplate.query("select * from sys_role", new BeanPropertyRowMapper<Role>(Role.class));
    }

    @Override
    public void save(Role role) {
        jdbcTemplate.update("insert into sys_role values (?,?,?)", null, role.getRoleName(), role.getRoleDesc());
    }

    /**
     * 根据用户的id查询角色
     *
     * @param id
     * @return
     */
    @Override
    public List<Role> findRoleById(Long id) {
        List<Role> roles = jdbcTemplate.query("select * from sys_user_role as ur ,sys_role as r where ur.roleId=r.id where ur.userId=?", new BeanPropertyRowMapper<>(Role.class), id);
        return roles;
    }
}
