package cn.itcast.datasource.druid;

import cn.itcast.datasource.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*使用新的工具类
* */
public class DruidDemo2 {
    public static void main(String[] args) {
     /*完成一个添加的操作 给account 添加一条记录
     */
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            //1.获取链接
             conn = JDBCUtils.getConnection();
            //2.定义sql
            String sql = "insert into account values(?,?,?)";
            //3.获取pstmt对象
             pstmt = conn.prepareStatement(sql);
            //4.给？赋值
            pstmt.setString(1,"3");
            pstmt.setString(2,"wangwu");
            pstmt.setInt(3,3000);
            //4.执行sql
           int count = pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt,conn);
        }
    }
}
