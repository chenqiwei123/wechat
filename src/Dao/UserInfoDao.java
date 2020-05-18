package Dao;

import DataBase.ConnectDataBase;
import User.UserInfo;
import WechatServlet.ConnectWeChatServlet;
import net.sf.json.JSONObject;
import org.apache.commons.codec.binary.Base64;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;


/**
 * 用户添加到数据库的操作
 */
public class UserInfoDao {


    public static int UpdateUserInfo(JSONObject jsonObject) throws SQLException, UnsupportedEncodingException {
        ConnectDataBase connectDataBase=new ConnectDataBase();
        Connection connection=connectDataBase.getConn();
        Statement st=null;
        int result=-1;
        String nickname=Base64.encodeBase64String(jsonObject.getString("nickname").getBytes("UTF-8"));
        String sql="UPDATE userInfo SET nickname = '"+nickname+"' ,sex = '"+jsonObject.getString("sex")+"' ,province = '"+jsonObject.getString("province")+"' ,city = '"+jsonObject.getString("city")+"' ,country = '"+jsonObject.getString("country")+"' ,headimgurl='"+jsonObject.getString("headimgurl")+"' WHERE openid = '"+jsonObject.getString("openid")+"' ";
        st=connection.createStatement();
        result=st.executeUpdate(sql);
        close(connection,st,null);
        return result;
    }

    /**
     * 将数据组装在UserInfo对象中
     * @param openid
     * @return
     */

    public static UserInfo OpenidGetUserInfo(String openid){
        String result1= ConnectWeChatServlet.getUserInfo(openid);
        JSONObject jsonObject1= JSONObject.fromObject(result1);
        UserInfo userInfo=new UserInfo(jsonObject1.getString("subscribe"),jsonObject1.getString("openid"),jsonObject1.getString("nickname")
                ,jsonObject1.getString("sex"),jsonObject1.getString("city")
                ,jsonObject1.getString("province"),jsonObject1.getString("country"),jsonObject1.getString("headimgurl")
                ,jsonObject1.getString("unionid"));
        return userInfo;
    }

    public static void main(String[] args) throws UnsupportedEncodingException, SQLException {
        System.out.println(Query("o1u0W1c7PFJPdfTCGMuC8bI0bxCg","data"));
    }
    /**
     * 查询用户是否存在
     * @param openid
     * @return
     */

    public static String Query(String openid,String type) throws SQLException, UnsupportedEncodingException {
        Map<String,String> map1=new HashMap<>();
        String result="";
        String sql="SELECT * FROM userInfo WHERE openid= ? ";
        System.out.println("sql:"+sql);
        ConnectDataBase connectDataBase=new ConnectDataBase();
        Connection con=connectDataBase.getConn();
        Statement stat=null;
        PreparedStatement ps=null;
        ResultSet resultSet=null;
        int a=-1;
//        try {
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,openid);
            resultSet=ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       if (type=="data"){
            while (resultSet.next()){
                Map<String,String> map=new HashMap<>();
                map.put("headimgurl",resultSet.getString("headimgurl"));
                map.put("subscribe",resultSet.getString("subscribe"));
                map.put("openid",resultSet.getString("openid"));
                map.put("nickname",new String(Base64.decodeBase64(resultSet.getString("nickname")),"UTF-8"));
                map.put("sex",resultSet.getString("sex"));
                map.put("province",resultSet.getString("province"));
                map.put("city",resultSet.getString("city"));
                map.put("country",resultSet.getString("country"));
                map.put("unionid",resultSet.getString("unionid"));
                map1.putAll(map);
            }
            JSONObject jsonObject=JSONObject.fromObject(map1);
            result=jsonObject.toString();
            }
         else if (type=="type"){
            if (!resultSet.next()){
                result="add";
            }
            else {
                result="update";
            }
            }
         else result= "您的类型填写错误，只支持data(查询结果)和type(查询数据库是否存在)";
            System.out.println("i:"+resultSet.getClass().getName());
        
            close(con,stat,resultSet);
            return result;
    }

    /**a变量：0表示添加更新， 其他的表示取消关注
     * 添加/更新用户
     * @param openid
     * @return
     */
    public static int AddUser(String openid,int a){
        String type = null;
        String subscribe=null;
        String sex=null;
        UserInfo userInfo=null;
        ResultSet rs=null;
        int resultNumber = 0;
        Connection conn = new ConnectDataBase().getConn();
        if (a==0){
            try {
                type=Query(openid,"type");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            userInfo=OpenidGetUserInfo(openid);
            subscribe=userInfo.getSubscribe();
            sex=userInfo.getSex();
            if (subscribe.equals("1")){
                subscribe="已订阅";
            }
            else if (subscribe.equals("0")){subscribe="取消订阅";}
            else subscribe="null";
            if (sex.equals("1")){
                sex="男";
            }
            else if (sex.equals("2")){
                sex="女";
            }
            else if (sex.equals("0")){
                sex="未知";
            }
            else sex="null";
        }
        else {
            type="unsubscribe";
        }
        boolean i=false;
        String sql;
        if (type.equals("add")){
            sql="insert into userInfo(subscribe,openid,nickname,city,province,country,headimgurl,unionid,sex) values" +
                    "(?,?,?,?,?,?,?,?,?)";
            try {
                String nickname=userInfo.getNickname();
                //进行编码
                try {
                    nickname = Base64.encodeBase64String(nickname.getBytes("UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                //进行解码
//                nickname = new String(Base64.decodeBase64(nickname),"UTF-8");
                PreparedStatement ps = conn.prepareStatement(sql);
                String myopenid=userInfo.getOpenid();
                String city=userInfo.getCity();
                String province=userInfo.getProvince();
                String country=userInfo.getCountry();
                String imgurl=userInfo.getHeadimgurl();
                ps.setString(1,subscribe);
                ps.setString(2,myopenid);
                ps.setString(3,nickname);
                ps.setString(4,city);
                ps.setString(5,province);
                ps.setString(6,country);
                ps.setString(7,imgurl);
                ps.setString(8,"0");
                ps.setString(9,sex);
                System.out.println("ps:"+ps);
                resultNumber=ps.executeUpdate();
                close(conn,ps,rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if (type.equals("update")){
            sql="update userInfo set ";
            sql+="subscribe='"+subscribe+"',nickname='"+userInfo.getNickname()+"',sex='"+sex+"',";
            sql+="city='"+userInfo.getCity()+"',province='"+userInfo.getProvince()+"',country='"+userInfo.getCountry()+"',headimgurl='"+userInfo.getHeadimgurl()+"',unionid='"+userInfo.getUnionid()+"' where openid='"+openid+"'";
            try {
                Statement st= conn.createStatement();
                resultNumber=st.executeUpdate(sql);
                close(conn,st,rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if (type.equals("unsubscribe")){
            sql="update userInfo set subscribe='取消订阅' where openid='"+openid+"'";
            try {
                Statement st=conn.createStatement();
                resultNumber=st.executeUpdate(sql);
                close(conn,st,rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
//        System.out.println("sql:"+sql);

        return resultNumber;
    }


    /**
     * 通过网页授权形式进行对象存储
     * @param userInfo
     * @return
     */
    public static int AddUserInfo(UserInfo userInfo){
        int resultNumber=0;
        ResultSet rs=null;
        String subscribe=userInfo.getSubscribe();
        String sex=userInfo.getSex();
        if (subscribe.equals("1")){
            subscribe="已订阅";
        }
        else if (subscribe.equals("0")){subscribe="取消订阅";}
        else subscribe="null";
        if (sex.equals("1")){
            sex="男";
        }
        else if (sex.equals("2")){
            sex="女";
        }
        else if (sex.equals("0")){
            sex="未知";
        }
        else sex="null";
        Connection conn=new ConnectDataBase().getConn();
            String sql="insert into userInfo(subscribe,openid,nickname,city,province,country,headimgurl,unionid,sex) values (?,?,?,?,?,?,?,?,?)";
        try {
            String nickname=userInfo.getNickname();
            //进行编码
            try {
                nickname = Base64.encodeBase64String(nickname.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            //进行解码
//                nickname = new String(Base64.decodeBase64(nickname),"UTF-8");
            PreparedStatement ps = conn.prepareStatement(sql);
            String myopenid=userInfo.getOpenid();
            String city=userInfo.getCity();
            String province=userInfo.getProvince();
            String country=userInfo.getCountry();
            String unionid=userInfo.getUnionid();
            String imgurl=userInfo.getHeadimgurl();
            ps.setString(1,subscribe);
            ps.setString(2,myopenid);
            ps.setString(3,nickname);
            ps.setString(4,city);
            ps.setString(5,province);
            ps.setString(6,country);
            ps.setString(7,imgurl);
            ps.setString(8,unionid);
            ps.setString(9,sex);
            System.out.println("ps:"+ps);
            resultNumber=ps.executeUpdate();
            close(conn,ps,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultNumber;
    }

    public static void close(Connection connection,Statement statement,ResultSet resultSet){
        try {
            if (connection != null)
                connection.close();
            if (statement != null)
                statement.close();
            if (resultSet != null)
                resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
