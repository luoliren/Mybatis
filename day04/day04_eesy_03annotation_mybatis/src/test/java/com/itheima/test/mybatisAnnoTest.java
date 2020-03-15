package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class mybatisAnnoTest {
    /**
     * 测试基于注解mybatis的使用
     * @param args
     */
    public static void main(String[] args) throws IOException {
        //1.获取字节输入流
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.根据输入流构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.根据SqlSessionFactory生产一个SqlSessions
        SqlSession session = sqlSessionFactory.openSession();
        //4.使用sqlSession获取Dao的代理对象
        IUserDao IUserDao = session.getMapper(IUserDao.class);
        //5.执行Dao的方法
        List<User> list = IUserDao.findAll();
        for (User user: list) {
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        inputStream.close();

    }
}
