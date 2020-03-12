package com.ithei.jdbc;

import java.sql.*;

/**
 * 程序的耦合
 * 耦合：程序间的依赖关系
 * 包括：类之间的依赖
 *      方法间的依赖
 *
 * 解耦：降低程序之间的依赖关系
 * 实际开发中：应做到 ，编译器不依赖，运行时才依赖
 * 解耦的思路：
 * 第一步：使用反射创建对象，而避免使用new关键字。
 * 第二步：通过读取配置文件来获取要创建的对象权限定类名
 */
public class JdbcDemo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
/*        //1.注册驱动
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());*/
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取链接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy01","root","990305");
        //3.获取操作数据库的预处理
        PreparedStatement pstm = connection.prepareStatement("select * from account");
        //4.执行SqL，得到结果集
        ResultSet rs = pstm.executeQuery();
        //5.遍历结果集
        while(rs.next()) {
            System.out.println(rs.getString("name"));
        }
        //6.释放资源
        rs.close();
        pstm.close();
        connection.close();
    }
}
