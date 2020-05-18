package EmailCheck;

import com.hnu.scw.utils.EmailCode;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

@WebServlet(name = "EmailCheckServlet")
public class EmailCheckServlet extends HttpServlet {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        Date afterDate = new Date(now.getTime() + 600000);
        System.out.println(sdf.format(afterDate ));
    }
    public static EmailCode emailCode;
    public static EmailCode random1(){
        String code = "";
        Random rd=new Random();
        for (int i = 0; i < 6; i++) {
            int r = rd.nextInt(10); //每次随机出一个数字（0-9）
            code = code + r;  //把每次随机出的数字拼在一起
        }
        long expired=System.currentTimeMillis()+600000;//定义验证码十分钟内有效
        emailCode=new EmailCode(code,expired);
        return emailCode;
    }
    public static String getEmailCode(){
        if(emailCode==null||emailCode.IsExpired()){
            random1();
        }
        return emailCode.getCode();
    }

    /**
     * 这个是创建email对象。然后链接自己邮箱的开放的密钥。
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HtmlEmail send = new HtmlEmail();//创建一个HtmlEmail实例对象
        // 获取随机验证码
        String email = request.getParameter("email");
        System.out.println("email:"+email);
        String resultCode=random1().getCode();
        System.out.println("code:"+resultCode);
        PrintWriter out =response.getWriter();
        try {
            Properties properties = System.getProperties();
            properties.setProperty("mail.smtp.auth", "true");//开启认证
            properties.setProperty("mail.debug", "true");//启用调试
            properties.setProperty("mail.smtp.timeout", "1000");//设置链接超时
            properties.setProperty("mail.smtp.port", "465");//设置端口
            properties.setProperty("mail.smtp.socketFactory.port", "465");//设置ssl端口
            properties.setProperty("mail.smtp.socketFactory.fallback", "false");
            properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            System.out.println("进入邮箱发送的处理！");
            send.setHostName("smtp.qq.com");
//            *eaqmnzjlujixbcah
            send.setAuthentication("chenqiwei1@foxmail.com", "kcxxhgwbodupbecf"); //第一个参数是发送者的QQEamil邮箱   第二个参数是刚刚获取的授权码

            send.setFrom("chenqiwei1@foxmail.com", "固定资产投资服务监管平台");//发送人的邮箱为自己的，用户名可以随便填  记得是自己的邮箱不是qq
			send.setSmtpPort(465); 	//端口号 可以不开
            send.setSSLOnConnect(true); //开启SSL加密
            send.setCharset("utf-8");
            send.addTo(email);  //设置收件人    email为你要发送给谁的邮箱账户   上方参数
            send.setSubject("【固定资产投资服务监管平台验证码已呈上】"); //邮箱标题
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date now = new Date();
            Date afterDate = new Date(now.getTime() + 600000);
            System.out.println(sdf.format(afterDate ));
            send.setMsg("<p style=\"font-size: x-large;\">Hello!终于等到你！欢迎来享受我们的服务，来来来，特此送上你饥渴难耐的验证码<p style=\"color:red;\">(此验证码在"+sdf.format(afterDate )+"前有效)</p></p> :<p style=\"font-size: xx-large;color: #1b00ff;\">"+resultCode+ "</p><p style=\"font-size: x-large;\">请(帅哥/美女)大大签收，记得给个五星好评哟！</p>"); //Eamil发送的内容
            String aa=send.send();  //发送
            System.out.println("发送情况："+aa);
           out.print("验证码发送成功!");
        } catch (EmailException e) {
           out.print("验证码发送失败!");
            e.printStackTrace();
        }
        out.flush();
        out.close();
    }




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
