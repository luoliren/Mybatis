package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class AnnotionCRUDTest {
    private InputStream inputStream;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession session;
    private IUserDao userDao;
    @Before
    public void init() throws IOException {
    inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
    sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    session = sqlSessionFactory.openSession();
    userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws IOException {
        session.commit();
        session.close();
        inputStream.close();
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setAddress("陕西");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setUsername("赵二狗");
        userDao.saveUser(user);

    }
    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(41);
        user.setAddress("西安");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setUsername("赵二狗");
        userDao.updateUser(user);
    }

    @Test
    public void testDelete() {
        userDao.deleteUser(20);
    }

    @Test
    public void testFindOne() {
        User user = userDao.findById(50);
        System.out.println(user);
    }

    @Test
    public void testFindByName() {
/*        List<User> users = userDao.findUserByName("%王%");*/
        List<User> users = userDao.findUserByName("mybatis");
        for (User user: users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal() {
        int totalUser = userDao.findTotalUser();
        System.out.println(totalUser);
    }


}
