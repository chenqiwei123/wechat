package CodeServlet;

import Dao.UserInfoDao;
import Dao.userLoginDao.UserLoginDao;
import Date.Joke;
import User.UserInfo;
import User.UserLoginInfo;
import com.hnu.scw.utils.TempOpenid;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

public class agreeMe extends HttpServlet {
    private static final long serialVersionUID=1L;
    private static UserInfo userInfo;
    public static HttpSession session;
    private static TempOpenid tempOpenid;

    protected void doPost(HttpServletRequest request, HttpServletResponse response){
    }
//    public static UserInfo saveUserInfo(JSONObject jsonObject){
//        try {
//            userInfo.setNickname(Base64.encodeBase64String(jsonObject.getString("nickname").getBytes("UTF-8")));
//        } catch (Exception e) {
//            System.out.println("编码格式出错误！");
//            e.printStackTrace();
//        }
//        userInfo.setCountry(jsonObject.getString("country"));
//        userInfo.setOpenid(jsonObject.getString("openid"));
//        userInfo.setUnionid("0");
//        try {
//            if (!UserLoginDao.LoginQuery(userInfo.getOpenid()).next()) {
//
//                httpSession.setAttribute("openid",UserInfo.getOpenid());
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        userInfo.setProvince(jsonObject.getString("province"));
//        userInfo.setCity(jsonObject.getString("city"));
//        userInfo.setHeadimgurl(jsonObject.getString("headimgurl"));
//        String sex=jsonObject.getString("sex");
//        if (sex.equals("1")) {
//            sex = "男神";
//        } else if (sex.equals("2")) {
//            sex = "女神";
//        } else if (sex.equals("0")) {
//            sex = "野鬼的";
//        } else {
//            sex = "获取信息失败！";
//        }
//        userInfo.setSex(sex);
//        System.out.println("userInfo:" + userInfo);
//        return userInfo;
//    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        UserInfo userInfo=new UserInfo();
        UserLoginInfo userLoginInfo=new UserLoginInfo();
        int UpdataResult=-1;
        String weiwei=null;
        PrintWriter out =response.getWriter();
        //设置代理
        System.getProperties().setProperty("http.proxyHost", "www.runwsh.com");
        System.getProperties().setProperty("http.proxyPort", "8080");
        String code=request.getParameter("code");
        System.out.println("code:"+code);
        System.out.println("codeType:");
        if (code==""||code==null||request.getParameter("code").equals(null)||request.getParameter("code").equals("")){
            try {
                request.getRequestDispatcher("error/NoWechat.jsp").forward(request,response);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            }
            return;

        }
            System.out.println("code:" + code);
            String url ="https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxcea26c733963d889&secret=e0d4867f02ecff50780971ec9698f5d4&code="+code+"&grant_type=authorization_code";
            System.out.println("url:" + url);
        try {
            weiwei=get(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("accessToOpenid"+weiwei);
        } catch (Exception e) {
            System.out.println("1、accessToOpenid抛出异常！");
            e.printStackTrace();
        }
        JSONObject jsonObject2 = null;
        try {
            jsonObject2 = JSONObject.fromObject(weiwei);
        } catch (Exception e) {
            System.out.println("2、accessToOpenid抛出异常！");
            e.printStackTrace();
        }
        System.out.println("用code换access_token的jsonobject2:" + jsonObject2);
//        if (jsonObject2.getString("openid").equals("")){
//            try {
//                request.getRequestDispatcher("error/NoWechat.jsp").forward(request,response);
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (ServletException e) {
//                e.printStackTrace();
//            }
//            return;
//        }
            String openid = jsonObject2.getString("openid");
            System.out.println("openid:"+openid);
//            session.setAttribute("openid",openid);
//        System.out.println("openid:"+session.getAttribute("openid"));
//            String type = null;
            String url2 = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
            url2 = url2.replace("ACCESS_TOKEN", jsonObject2.getString("access_token")).replace("OPENID", openid);
            String result2 = Joke.get(url2);
//            UserInfo userInfo=saveUserInfo(JSONObject.fromObject(result2));
//            httpSession.setAttribute("userInfo", userInfo);
        try {
            System.out.println("跳转中！。。。。");
            System.out.println("openid:----"+openid);
            JSONObject json=JSONObject.fromObject(result2);
            UpdataResult=UserInfoDao.UpdateUserInfo(json);
//                    保存用户信息
            userInfo.setOpenid(json.getString("openid"));
            userInfo.setNickname(json.getString("nickname"));
            userInfo.setProvince(json.getString("province"));
            String sex="";
            if (json.getString("sex").equals(1)){
                sex="男";
            }
            else {
                sex="女";
            }
            userInfo.setSex(sex);
            userInfo.setCity(json.getString("city"));
            userInfo.setCountry(json.getString("country"));
            userInfo.setSubscribe("已订阅");
            userInfo.setHeadimgurl(json.getString("headimgurl"));
            session.setAttribute("userInfo", userInfo);
            if (UserLoginDao.LoginQuery(openid)==1)
                {
                    JSONObject jsonLogin=JSONObject.fromObject(UserLoginDao.LoginQueryResult(openid));
                    userLoginInfo.setEmail(jsonLogin.getString("email"));
                    userLoginInfo.setIndentityType(jsonLogin.getString("type"));
//                    session.setAttribute("openid",openid);
                    session.setAttribute("userLogin",userLoginInfo);
                    //对用户进行更新
                    request.getRequestDispatcher("User/PersonalCenter.jsp").forward(request,response);
            }
            else {
                out.print("您还未注册，快来注册吧！");
                request.getRequestDispatcher("UserLogin/UserLogin.jsp").forward(request,response);
            }
        } catch (Exception e) {
            System.out.println("跳转异常！");
            e.printStackTrace();
        }
        finally {
            out.flush();
            out.close();
        }
    }
    public static String get(String url) throws Exception{
        URL urlObject= null;
        urlObject = new URL(url);
        URLConnection connection= null;
        connection = urlObject.openConnection();
        InputStream is = null;
        try {
            is = connection.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("is:"+is);
            byte[] b=new byte[1024];
            int len;
            StringBuilder sb=new StringBuilder();
            while ((len=is.read(b))!=-1){
                sb.append(new String(b,0,len));
            }
            if (is!=null){
             is.close();
            }
            return sb.toString();
    }
}
