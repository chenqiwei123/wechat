package CodeServlet.project;

import User.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static Manager.TemplateMessageManager.sendTemplateMessage;

@WebServlet(name = "projectApplyServlet")
public class projectApplyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("项目申请servlet:");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        UserInfo userInfo=(UserInfo)request.getSession().getAttribute("userInfo");
        String p1_name=request.getParameter("p1_name");
        String p1_address=request.getParameter("p1_address");
        String p1_code=request.getParameter("p1_code");
        String p1_time=request.getParameter("p1_time");
        String p1_code2=request.getParameter("p1_code2");
        String p1_number=request.getParameter("p1_number");
        String p2_name=request.getParameter("p2_name");
        String p2_code=request.getParameter("p2_code");
        String p2_tel=request.getParameter("p2_tel");
        String p2_person=request.getParameter("p2_person");
        String p2_phone=request.getParameter("p2_phone");
        String p2_email=request.getParameter("p2_email");
        String p2_adress=request.getParameter("p2_adress");
//        String p3_file=request.getParameter("p3_file");
        String p3_info=request.getParameter("p3_info");
        String value=request.getParameter("value");
        String openid=userInfo.getOpenid();
        response.setContentType("text/html");

        Map<String,String> map= new HashMap<>();
        map.put("p1_name",p1_name);
        map.put("p1_address",p1_address);
        map.put("p1_code",p1_code);
        map.put("p1_time",p1_time);
        map.put("p1_code2",p1_code2);
        map.put("p1_number",p1_number);
        map.put("p2_name",p2_name);
        map.put("p2_code",p2_code);
        map.put("p2_tel",p2_tel);
        map.put("p2_person",p2_person);
        map.put("p2_phone",p2_phone);
        map.put("p2_email",p2_email);
        map.put("p2_adress",p2_adress);
//        map.put("p3_file","http://www.runwsh.com/chen/upload/"+rename);
        map.put("p3_info",p3_info);
        map.put("value",value);
        map.put("openid",openid);
        map.put("result","待审核");
        System.out.println("项目申请的数据到servlet中map:"+map);
        try {
            if (Dao.projectInfoDao.addProjectInfo(map)!=-1){
                sendTemplateMessage(openid);
                out.write("项目申请成功！");
                request.getRequestDispatcher("homepage/projectInfo.jsp").forward(request,response);
            }
            else {
                out.write("项目申请失败，请重新申请！");
                request.getRequestDispatcher("homepage/projectInfo.jsp").forward(request,response);
            }
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
