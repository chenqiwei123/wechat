package CodeServlet.project;

import Dao.projectInfoDao;
import User.UserInfo;
import User.UserLoginInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "GetProjectInfoServlet")
public class GetProjectInfoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int noOpenid=-1;
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out =response.getWriter();
        String projectInfo="";
        UserInfo userInfo=(UserInfo)request.getSession().getAttribute("userInfo");
        projectInfoDao project =new projectInfoDao();
        UserLoginInfo userLoginInfo=(UserLoginInfo)request.getSession().getAttribute("userLogin");
        try {
            if (userLoginInfo.getIndentityType().equals("发改部门")){
                noOpenid=0;
            }
            else {
                noOpenid=1;
            }
            projectInfo=project.QueryProjectInfo(userInfo.getOpenid(),noOpenid);
//            System.out.println("项目信息增加："+projectInfo);
            out.print(projectInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            out.flush();
            out.close();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
