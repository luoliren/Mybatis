package it.heima.test;

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
import java.util.List;

/**
 * 测试mybatis的crud操作
 */
public class UserTest {
    private InputStream inputStream;
    private SqlSession session;
    private IUserDao userDao;
    private SqlSessionFactory factory;

    @Before//用于在测试方法执行之前测试
    public void init() throws IOException {
        //读取配置文件，生成字节输入流
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获取SqlSessionFactory
         factory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象
        session = factory.openSession(true);
        /*如果将openSession的值设为true，就是自动提交，则可以省略    session.commit();  */
        //获取代理对象
        userDao = session.getMapper(IUserDao.class);
    }

    @After//用于测试方法之后
    public void destroy() throws IOException {
        //提交事务
       // session.commit();
        //释放资源
        session.close();
        inputStream.close();
    }

    /**
     * 测试一级缓存
     */
    @Test
    public void testFirstLevelCache(){
        User user1 = userDao.findById(41);
        System.out.println(user1);
       /* session.close();
        *//*再次开启SqlSession对象*//*
        session = factory.openSession();*/
        session.clearCache();//可以清空缓存
        userDao = session.getMapper(IUserDao.class);
        User user2 = userDao.findById(41);
        System.out.println(user2);

        System.out.println(user1==user2);

    }

    /**
     * 测试缓存同步
     */
    @Test
    public void testClearCache(){
        //1.根据id查询用户
        User user1 = userDao.findById(41);
        System.out.println(user1);
        //2.更新用户信息
        user1.setUsername("update user clear cache ");
        user1.setAddress("北京市");

        userDao.updateUser(user1);
        //3.再次查询id=41的用户
        User user2 = userDao.findById(41);
        System.out.println(user2);

        System.out.println(user1==user2);

    }
}

