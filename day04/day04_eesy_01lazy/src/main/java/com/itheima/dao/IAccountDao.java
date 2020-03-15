package com.itheima.dao;

import com.itheima.domain.Account;
import com.itheima.domain.AccountUser;

import java.util.List;

public interface IAccountDao {
    /**
     * 查询所有的账户,同时获取到用户下的所有账户信息
     * @return
     */
    List<Account> findAll();

    /**
     * 根据用户的id查询用户信息
     * @return
     */
    List<Account> findAccountByUid();
}
