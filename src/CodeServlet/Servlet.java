package CodeServlet;

import WechatServlet.ConnectWeChatServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if (session==null){
            try {
                request.getRequestDispatcher("error/NoWechat.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
            return;
        }
        PrintWriter out=response.getWriter();
        String ticket = ConnectWeChatServlet.getOrCodeTicket();
        out.print(ticket);
        out.flush();
        out.close();
    }
}
