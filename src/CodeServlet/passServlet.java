package CodeServlet;

import Dao.projectInfoDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "passServlet")
public class passServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int aa=-1;
        PrintWriter out=response.getWriter();
        String openid=request.getParameter("openid");
        String id=request.getParameter("id");
        String content=request.getParameter("content");
        try {
            aa= projectInfoDao.passProject(id,content);
            if (aa!=-1){
                Manager.TemplateMessageManager.PasssendTemplateMessage(openid);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        out.flush();
        out.close();
    }
}
