package it.heima.test;

import com.itheima.dao.IRoleDao;
import com.itheima.dao.IUserDao;
import com.itheima.domain.Role;
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
public class RoleTest {
    private InputStream inputStream;
    private SqlSession session;
    private IRoleDao roleDao;

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
        roleDao = session.getMapper(IRoleDao.class);
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
     * 测试查询所有,
     */
    @Test
    public void testFindAll(){
    List<Role> roles = roleDao.findAll();
        for (Role role : roles) {
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }
}

