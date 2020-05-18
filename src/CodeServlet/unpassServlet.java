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

@WebServlet(name = "unpassServlet")
public class unpassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int aa=-1;
        PrintWriter out=response.getWriter();
        String openid=request.getParameter("openid");
        String content=request.getParameter("content");
        String id=request.getParameter("id");
        try {
            aa=projectInfoDao.passProject(id,content);
            if (aa!=-1){
                Manager.TemplateMessageManager.sendUnPassProjectMessage(openid);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int aa=-1;
        PrintWriter out=response.getWriter();
        String openid=request.getParameter("openid");
        String content=request.getParameter("content");
        String id=request.getParameter("id");
        try {
            aa=projectInfoDao.passProject(id,content);
            if (aa!=-1){
                Manager.TemplateMessageManager.sendUnPassProjectMessage(openid);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        out.flush();
        out.close();

    }
}
