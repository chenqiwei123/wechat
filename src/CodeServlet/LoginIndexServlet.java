package CodeServlet;

import Dao.UserInfoDao;
import Dao.userLoginDao.UserLoginDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 邮箱登录的验证servlet
 */
@WebServlet(name = "LoginServlet")
public class LoginIndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
    int chenqiwei=-1;//验证Dao包查询结果
    String email=request.getParameter("email");
    String password=request.getParameter("password");
    String type=request.getParameter("type");
        HttpSession session = request.getSession(false);
        if (session==null){
        try {
            request.getRequestDispatcher("error/NoWechat.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return;
    }
    chenqiwei=UserLoginDao.EamilLogin(email,password,type);
    if (chenqiwei>0){
        session.setAttribute("userLogin",UserLoginDao.LoginQueryResult(String.valueOf(session.getAttribute("openid"))));
        try {
            session.setAttribute("userInfo", UserInfoDao.Query(String.valueOf(session.getAttribute("openid")),"data"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (type.equals("项目法人")){
            response.getWriter().print("登录成功");
            request.getRequestDispatcher("homepage/projectperson.jsp").forward(request,response);
            return;
        }
        else if (type.equals("行业主管")){
            response.getWriter().print("登录成功");
            request.getRequestDispatcher("homepage/Supervisor.jsp").forward(request,response);
            return;
        }
        else if (type.equals("发改部门")){
            response.getWriter().print("登录成功");
            request.getRequestDispatcher("homepage/reform.jsp").forward(request,response);
            return;
        }
        else {
            response.getWriter().print("登录失败");
            request.getRequestDispatcher("User/PersonalCenter.jsp").forward(request,response);
            return;
        }

    }
    else {
        response.getWriter().write("登录失败");
        request.getRequestDispatcher("UserLogin/UserLogin.jsp").forward(request,response);
        return;
    }
}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
