package it.heima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.QueryVo;
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
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 测试mybatis的crud操作
 */
public class MybatisTest {
    private InputStream inputStream;
    private SqlSession session;
    private IUserDao userDao;

    @Before//用于在测试方法执行之前测试
    public void init() throws IOException {
        //读取配置文件，生成字节输入流
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
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

    @Test
    public void testFindAll() {

        //执行查询所有的方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }

    }


    /**
     * 测试查询操作
     */
    @Test
    public void testFindOne() throws IOException {

        //执行查寻一个方法
        User user = userDao.findById(41);
        System.out.println(user);
    }
    /**
     * 测试模糊查询操作
     */
    @Test
    public void testFindByName() throws IOException {
        //执行查寻一个方法
        List <User>users = userDao.findByName("%王%");
        for (User user:users) {
            System.out.println(user);
        }
    }

    /**
     * 测试使用QueryVo作为查询条件
     */
    @Test
    public void testindUserByVo() throws IOException {
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        queryVo.setUser(user);
        List <User>users = userDao.findUserByVo(queryVo);
        for (User u:users) {
            System.out.println(u);
        }
    }

    @Test
    public void testFindByCondition() {
        User u = new User();
        u.setUsername("老王");
        //执行查询所有的方法
        List<User> users = userDao.findUserByCondition(u);
        for (User user : users) {
            System.out.println(user);
        }

    }

    /**
     * 测试foreach标签的使用
     */
    @Test
    public void testFindInIds() {
      QueryVo queryVo = new QueryVo();
      List<Integer> list = new ArrayList<Integer>();
      list.add(41);
      list.add(42);
      list.add(46);
      queryVo.setIds(list);
        //执行查询所有的方法
        List<User> users = userDao.findUserInIds(queryVo);
        for (User user : users) {
            System.out.println(user);
        }

    }
}

