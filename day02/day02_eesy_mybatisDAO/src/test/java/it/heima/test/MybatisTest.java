package it.heima.test;

import com.itheima.dao.IUserDao;
import com.itheima.dao.impl.UserDaoImpl;
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
       //使用工厂对象，创建dao对象
        userDao = new UserDaoImpl(factory);

    }

    @After//用于测试方法之后
    public void destroy() throws IOException {

        //释放资源

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
     * 测试保存操作
     */
    @Test
    public void testSave() throws IOException {
        User user = new User();
        user.setUsername("mybatis last user");
        user.setAddress("陕西");
        user.setSex("男");
        user.setBirthday(new Date());
        //执行保存的方法
        userDao.saveUser(user);
        System.out.println(user);

    }

    /**
     * 测试保存操作
     */
    @Test
    public void testUpdate() throws IOException {
        User user = new User();
        user.setId(44);
        user.setUsername("mybatis update");
        user.setAddress("天津");
        user.setSex("女");
        user.setBirthday(new Date());
        //执行保存的方法
        userDao.updateUser(user);

        }

    /**
     * 测试删除操作
     */
    @Test
    public void testDelete() throws IOException {

        //执行删除的方法
        userDao.deleteUser(43);

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
     * 测试查询总记录条数操作
     */
    @Test
    public void testFindTotal() throws IOException {
        //执行查寻一个方法
        int count = userDao.findTotal();
        System.out.println(count);
    }

}

