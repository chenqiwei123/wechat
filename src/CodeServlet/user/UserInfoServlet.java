package CodeServlet.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();
        HttpSession session = request.getSession(false);
        if (session==null){
            try {
                request.getRequestDispatcher("error/NoWechat.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
            return;
        }

        try {
            out.write("进入我的消息页面");
            request.getRequestDispatcher("User/UserInfo.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.flush();
        out.close();

    }
}
