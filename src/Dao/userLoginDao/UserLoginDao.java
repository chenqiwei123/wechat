package Dao.userLoginDao;

import Dao.UserInfoDao;
import DataBase.ConnectDataBase;
import MD5.Md5;
import net.sf.json.JSONObject;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;


/**用户登录的数据库操作
 *
 */
public class UserLoginDao {

    /**
     * 查询用户(用openid)登录的表格并且返回查询数据
     * @param openid
     * @return
     * @throws SQLException
     */
    public static int LoginQuery(String openid) throws SQLException {
        int result = 0;
        Statement ps=null;

        String sql="SELECT * FROM userlogin WHERE openid='"+openid+"'";
        Connection con=new ConnectDataBase().getConn();
        try {
            ps = con.createStatement();
            ResultSet rs=ps.executeQuery(sql);
//            System.out.println("Agree result:"+rs.next());
//            System.out.println("a:"+a);
            if (rs.next()){
                System.out.println("111");
                result=1;
            }
            if (con!=null) con.close();
            if (ps!=null) ps.close();
            if (rs!=null) rs.close();
            System.out.println("Login+result:"+result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
           if (con!=null) con.close();
           if (ps!=null) ps.close();
        return result;
    }

    public static int EamilLogin(String email,String password,String type){
        String sql="select * from userlogin where email=? and password=? and type1=?";
        int result=-1;
        PreparedStatement ps=null;
        ResultSet rs=null;
        ConnectDataBase connectDataBase=new ConnectDataBase();
        Connection conn=connectDataBase.getConn();
        try {
            ps=conn.prepareStatement(sql);//预编译sql语句
            ps.setString(1,email);
            ps.setString(2,password);
            ps.setString(3,type);
            result=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        UserInfoDao.close(conn,ps,rs);
        return result;
    }


    public static String LoginQueryResult(String openid){
        String sql="SELECT * FROM userlogin WHERE openid=?";
        PreparedStatement ps=null;
        ResultSet resultSet=null;
        Map<String,String> map1=new HashMap<>();
        ConnectDataBase connectDataBase=new ConnectDataBase();
        Connection conn=connectDataBase.getConn();
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,openid);
            resultSet=ps.executeQuery();
            while (resultSet.next()){
                Map<String,String> map=new HashMap<>();
                map.put("email",resultSet.getString("email"));
                map.put("password",resultSet.getString("password"));
                map.put("type",resultSet.getString("type1"));
                map1.putAll(map);
            }
            JSONObject jsonObject=JSONObject.fromObject(map1);
//            System.out.println(JSONObject.fromObject(jsonObject.toString()).getString("type"));
            if (ps!=null){
                ps.close();
            }
            if (conn!=null){
                conn.close();
            }
            if (resultSet!=null){
                resultSet.close();
            }
            return jsonObject.toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "获取失败。。。";

    }

    public static void main(String[] args) throws SQLException{
//        LoginQuery("o1u0W1c7PFJPdfTCGMuC8bI0bxCg");
        Map<String,String> map=new HashMap<>();
        map.put("username","runwsh");
        map.put("password",Md5.getMd5("chen123456"));
        map.put("email","1049563035@qq.com");
        map.put("openid","o1u0W1c7PFJPdfTCGMuC8bI0bxCg111111111");
        map.put("type", "项目法人");
        AddUserLogin(map);
    }
    /**
     * 添加注册的用户信息到数据库当中去
     * @param map
     * @return
     * @throws SQLException
     */
    public static String AddUserLogin(Map<String,String> map) throws SQLException {
        String result="";
        if (LoginQuery(map.get("openid"))==1){
            return "该微信号已经注册，快去登录吧！";
        }
        PreparedStatement ps=null;
        int addReault = -1;
        String sql=null;
        ConnectDataBase con=new ConnectDataBase();
        sql="insert into userlogin(username,password,email,openid,type1) values(?,?,?,?,?)";
        try {
            ps=con.getConn().prepareStatement(sql);
            ps.setString(1,map.get("username"));
            ps.setString(2,map.get("password"));
            ps.setString(3,map.get("email"));
            ps.setString(4,map.get("openid"));
            ps.setString(5,map.get("type"));
            addReault=ps.executeUpdate();
            System.out.println(addReault);
            if (addReault>0){
                result ="success";
            }
            else {
                result="error";
            }
            if (ps!=null){
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return result;
    }


    public static String EmailLogin(String email,String password) throws SQLException{
        boolean result=false;
        String res="";
        password=Md5.getMd5(password);
        ConnectDataBase conn= new ConnectDataBase();
        String sql="select * from userlogin where email=? and password=?";
        try {
            PreparedStatement ps=conn.getConn().prepareStatement(sql);
            ps.setString(1,email);
            ps.setString(2,password);
            result=ps.execute();
            if (ps!=null){
                ps.close();
            }
            if (result){
                return "success";
            }
            else {
                return "error";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "mistake";
    }
}
