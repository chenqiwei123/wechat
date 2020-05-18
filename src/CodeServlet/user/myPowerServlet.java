package CodeServlet.user;

import User.UserLoginInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "myPowerServlet")
public class myPowerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserLoginInfo userLoginInfo=(UserLoginInfo)request.getSession().getAttribute("userLogin");
        String type=userLoginInfo.getIndentityType();
        System.out.println("进入servlet中的type："+type);
        System.out.println("进入servlet中的type类型："+type.getClass());
        if (userLoginInfo.getIndentityType().equals("项目法人")){
            request.getRequestDispatcher("homepage/projectperson.jsp").forward(request,response);
            return;
        }
        else if (userLoginInfo.getIndentityType().equals("主管部门")){
            request.getRequestDispatcher("homepage/Supervisor.jsp").forward(request,response);
            return;
        }
        else if (userLoginInfo.getIndentityType().equals("发改部门")){
            request.getRequestDispatcher("homepage/reform.jsp").forward(request,response);
            return;
        }
        else {
            request.getRequestDispatcher("error/NoWechat.jsp").forward(request,response);
            return;
        }

    }
}
