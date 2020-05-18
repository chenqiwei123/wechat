package test;

import com.baidu.aip.ocr.AipOcr;
import com.hnu.scw.utils.EmailCode;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Random;

public class text {
    public static EmailCode emailCode;
    public static final String APP_ID = "18403278";
    public static final String API_KEY = "KiybGkwKuUDRxZTsGwT8XANd";
    public static final String SECRET_KEY = "rV753DCEGUTKkyCaqIQce45lKrOhfZVW";
    public static void main(String[] args) {
//       String file="C:\\Users\\RunWsh\\Desktop\\(5).jpg";
//       String path="https://api.weixin.qq.com/cgi-bin/media/get?access_token=30_gtKvBqmgsoZWA48oQHHpAgjNy4NV6nIs1iNbbzFyOGPuqtqp6XU5bFFmyqBy0LtHFIM4h5Ghq3Qt1_-OxAgW0Xk18Lji9ZeAZzXJkL8d4buua7KuqIxs2WdMnO0PBReAFAUGW&media_id=YAd7El4LKyZdtI3E487QXS-4Dfl3xsvT-okZJGsqwi_Bo9yZO9CnuJN_uvm6NWsp";
//            String type="image";
//            String result1= ConnectWeChatServlet.download(file,type);
//            System.out.println("result:"+result1);
//      System.out.println();
//        imageSeeWord();
        email("3624026656@qq.com");
    }
    public static void imageSeeWord(){
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
//        client.setConnectionTimeoutInMillis(2000);
//        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
//        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        String path = "C:\\Users\\RunWsh\\Desktop\\dytdfut.png";
        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());

        System.out.println(res.toString(2));
    }
    public static void email(String email){
        HtmlEmail send = new HtmlEmail();//创建一个HtmlEmail实例对象
        // 获取随机验证码
//        String email = request.getParameter("email");
//        System.out.println("email:"+email);
        String resultCode=random1().getCode();
        try {
            send.setHostName("smtp.qq.com");
            send.setAuthentication("chenqiwei1@foxmail.com", "eaqmnzjlujixbcah"); //第一个参数是发送者的QQEamil邮箱   第二个参数是刚刚获取的授权码

            send.setFrom("chenqiwei1@foxmail.com", "固定资产投资服务监管平台");//发送人的邮箱为自己的，用户名可以随便填  记得是自己的邮箱不是qq
//			send.setSmtpPort(465); 	//端口号 可以不开
            send.setSSLOnConnect(true); //开启SSL加密
            send.setCharset("utf-8");
            send.addTo(email);  //设置收件人    email为你要发送给谁的邮箱账户   上方参数
            send.setSubject("【固定资产投资服务监管平台验证码已呈上】"); //邮箱标题
            send.setMsg("Hello!终于等到你！欢迎来享受我们的服务，来来来，特此送上你饥渴难耐的验证码(有效期十分钟) :<p style=\"color:red;\">"+resultCode+ "</p>请(帅哥/美女)大大签收，记得给个五星好评哟！"); //Eamil发送的内容
            String aa=send.send();  //发送
            System.out.println("发送情况："+aa);
//            response.getWriter().print("验证码发送成功");
        } catch (EmailException e) {
//            response.getWriter().print("验证码发送失败");
            e.printStackTrace();
        }
    }
    public static EmailCode random1(){
        String code = "";
        Random rd=new Random();
        for (int i = 0; i < 6; i++) {
            int r = rd.nextInt(10); //每次随机出一个数字（0-9）
            code = code + r;  //把每次随机出的数字拼在一起
        }
        long expired=System.currentTimeMillis()+600000;
        emailCode=new EmailCode(code,expired);
        return emailCode;
    }
    public static String getEmailCode(){
        if(emailCode==null||emailCode.IsExpired()){
            random1();
        }
        return emailCode.getCode();
    }

}
