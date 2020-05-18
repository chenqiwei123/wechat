package EmailCheck;

import Dao.userLoginDao.UserLoginDao;
import MD5.Md5;
import Manager.TemplateMessageManager;
import User.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class EmailLoginServlet extends HttpServlet {
    String result="";

    /**
     * 验证注册
     * @param request
     * @param response
     */
    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("验证码验证++++");
        HttpSession httpSession=request.getSession();
        System.out.println("code:"+request.getParameter("code"));
        System.out.println("type:"+request.getParameter("type"));
        System.out.println("getemailcode:"+EmailCheckServlet.getEmailCode());
        PrintWriter out=response.getWriter();
        String openid= (String) httpSession.getAttribute("openid");
//        if (openid==null&&openid.equals("false")){
//            out.print("请用微信登录！");
//            out.flush();
//            out.close();
//            try {
//                request.getRequestDispatcher("error/NoWechat.jsp").forward(request,response);
//            } catch (ServletException e) {
//                e.printStackTrace();
//            }
//            return;
//        }

        if(request.getParameter("code").equals(EmailCheckServlet.getEmailCode())){
            System.out.println("注册信息Servlet");
            String username= request.getParameter("username");
            String password=Md5.getMd5(request.getParameter("password"));
            String email=request.getParameter("email");
            String type=request.getParameter("type");
            Map<String,String> map=new HashMap<>();
            map.put("username",username);
            map.put("password",password);
            map.put("email",email);
            map.put("type",type);
//            System.out.println("httpSession:"+httpSession);
            UserInfo userInfo=(UserInfo)request.getSession().getAttribute("userInfo");
            System.out.println("openid:"+userInfo.getOpenid());
            map.put("openid", userInfo.getOpenid());
            System.out.println("注册的map:"+map);
//            UserLoginInfo userLoginInfo=new UserLoginInfo(username,email,password,type,openid);
            try {
                result=UserLoginDao.AddUserLogin(map);//返回String类型，，注册成功/注册失败
//                httpSession.setAttribute("userLogin", JSONObject.fromObject(map).toString());
//                httpSession.setAttribute("userInfo", UserInfoDao.Query(map.get("openid"),"data"));
//                response.getWriter().print("注册成功了！");
                if (result.equals("success")){
                    TemplateMessageManager.sendRegistTemplateMessage(userInfo.getOpenid());
                    out.print("注册成功了！");
                    request.getRequestDispatcher("User/PersonalCenter.jsp").forward(request,response);
                }
                else {
                    out.println(result);
                    request.getRequestDispatcher("UserLogin/UserLogin.jsp").forward(request,response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            out.print("验证码错误哟，清重新注册！");
            try {
                request.getRequestDispatcher("UserLogin/UserLogin.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }

    public static void main(String[] args) {

    }
}
