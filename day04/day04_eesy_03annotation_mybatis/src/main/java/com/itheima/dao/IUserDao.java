package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 在mybatis中针对，CRUD一共有四个注解
 * @Select @Insert @Update @Delete
 */
public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     */
    /*@Select(value = "") 其中value可以省略，有一个属性可以省略*/
    @Select("select * from user")
    List<User> findAll();
    @Select("insert into user(username,address,sex,birthday)values(#{username},#{address},#{sex},#{birthday})")
    void saveUser(User user);
    @Select("update user set username =#{username},sex=#{sex},birthday= #{birthday},address = #{address} where id = #{id}")
    void updateUser(User user);
    @Select("delete from user where id =#{id}")
    void deleteUser(Integer integer);
    @Select("select *from user where id= #{id}")
    User findById(Integer userId);
    /*@Select("select * from user where username like #{username}")*/
    @Select("select * from user where username like '%${value}%'")
    List<User> findUserByName(String username);
    @Select("select count(*) from user")
    int findTotalUser();
}
