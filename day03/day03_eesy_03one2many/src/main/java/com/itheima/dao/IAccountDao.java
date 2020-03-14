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
     * 查询所有账户，并且带有用户名和地址信息
     * @returnA
     */
    List<AccountUser> findAllAccount();
}
