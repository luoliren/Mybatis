package cn.itcast.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/*
    C3p0演示
 */
public class C3p0Demo2 {
    public static void main(String[] args) throws SQLException {
/*        //获取DataSource 使用默认配置
        DataSource ds = new ComboPooledDataSource();
        //获取链接
        for (int i = 1 ;i <=11 ; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i+":"+conn);

            if (i == 5) {
                conn.close();//归还连接到连接池中
            }
        }*/
        textNamedConfig();
    }
    public  static void textNamedConfig() throws SQLException {
        //
        //1.1获取DataSource使用指定名称的复制
        DataSource ds = new ComboPooledDataSource("otherc3p0");
        for (int i = 1 ;i <= 10 ; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i+":"+conn);


        }
    }
}
