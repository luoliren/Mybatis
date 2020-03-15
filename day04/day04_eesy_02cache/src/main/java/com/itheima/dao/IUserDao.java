package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface IUserDao {
    /**
     * 查询所有方法
     * @return
     */
    List<User>findAll();

    /**
     * 根据id查寻用户的信息
     * @param userId
     * @return
     */
    User findById(Integer userId);

    /**
     * 更新用户信息
     * @param user
     */
    void updateUser(User user);
}
