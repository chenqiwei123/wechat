package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDataBase {
    private String dbUrl="jdbc:mysql://175.24.12.113/wechat?characterEncoding=utf8";
    private String dbUser="root";
    private String dbPassword="Chen123456...";
    private String jdbcName="com.mysql.cj.jdbc.Driver";

    //连接数据库
    public Connection getConn(){
        Connection conn = null;
        try{
            Class.forName(jdbcName);
        }
        catch(Exception e){
            System.out.println("注册驱动异常："+e);
        }
        try{
            conn=DriverManager.getConnection(dbUrl,dbUser,dbPassword);
            System.out.println("数据库链接成功："+conn);
        }
        catch(SQLException ex){
            System.out.println("数据库连接异常："+ex);
        }
        return conn;
    }
    public static void main(String[] args)
    {
        System.out.println((new ConnectDataBase().getConn()));
        
    }
}
