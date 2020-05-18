package CodeServlet;

import Dao.userLoginDao.UserLoginDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EmailLoginServlet")
public class EmailLoginServlet extends HttpServlet {
    String result="";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        System.out.println("Login_session:"+session.getAttribute("openid"));
        if (session.getAttribute("openid")==null){
            try {
                request.getRequestDispatcher("error/NoWechat.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
            return;
        }
        String password=request.getParameter("password");
        System.out.println("Login_password:"+password);
        String email=request.getParameter("email");
        System.out.println("Login_email:"+email);
        try {
            result=UserLoginDao.EmailLogin(email,password);
            request.setAttribute("result",result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result.equals("success")){
            request.getRequestDispatcher("User/PersonalCenter.jsp").forward(request,response);
        }
        else if(result.equals("error")){
            request.getRequestDispatcher("UserLogin/UserLogin.jsp").forward(request,response);
        }
        else {
            request.getRequestDispatcher("error/NoWechat.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
