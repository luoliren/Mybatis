package it.heima.test;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.IUserDao;
import com.itheima.domain.Account;
import com.itheima.domain.AccountUser;
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
import java.util.ArrayList;
import java.util.List;

/**
 * 测试mybatis的crud操作
 */
public class AccountTest {
    private InputStream inputStream;
    private SqlSession session;
    private IAccountDao accountDao;

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
        accountDao = session.getMapper(IAccountDao.class);
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
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println("----这是每个account的信息-----");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }


}

