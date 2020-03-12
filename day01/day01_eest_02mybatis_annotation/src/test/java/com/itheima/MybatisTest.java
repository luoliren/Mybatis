package com.itheima;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    /**
     * 入门案例
     * @param args
     */
    public static void main(String[] args) throws IOException {
       //1.读取配置文件
        InputStream inputStream  = Resources.getResourceAsStream("SqlMapConfig.xml");

       //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder =new SqlSessionFactoryBuilder();
        SqlSessionFactory factory =builder.build(inputStream);
       //3.使用工厂生产SeqSession对象
        SqlSession session = factory.openSession();
       //4.使用sqlSession创建Dao接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
       //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user:users) {
            System.out.println(user);
        }
       //6.释放资源
        session.close();
        inputStream.close();
    }
}
