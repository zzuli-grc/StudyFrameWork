package com.study.mapper;

import com.study.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountMapper {
    /**
     * 保存账户
     *
     * @param account
     */
    void save(Account account);

    /**
     * 查询所有账户
     *
     * @return
     */
    List<Account> findAll();

}
