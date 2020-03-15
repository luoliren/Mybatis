package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

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
    @Results(id = "userMap" ,value = {
            @Result(id = true,column = "id",property = "userId"),
            @Result(column = "username",property = "userName"),
            @Result(column = "address",property = "userAddress"),
            @Result(column = "birthday",property = "userBirthday"),
            @Result(column = "sex",property = "userSex"),
            @Result(property = "accounts",column = "id",
                    many = @Many(select = "com.itheima.dao.IAccountDao.findAccountByUid",fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    @Select("select *from user where id= #{id}")
    /*数组只有一个元素可以省略大括号 resultMap只有一个元素可以省略value*/
    @ResultMap(value = {"userMap"})
    User findById(Integer userId);
    @Select("select * from user where username like #{username}")
    List<User> findUserByName(String username);

}
