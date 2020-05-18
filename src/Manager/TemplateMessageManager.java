package Manager;

import Date.Joke;
import WechatServlet.ConnectWeChatServlet;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;

public class TemplateMessageManager {
    public static final String DEF_CHATSET = "UTF-8";
    public static void main(String[] args) {
        sendUnPassProjectMessage("o1u0W1fCwDh4XNlfv2jeyIljdWDk");
    }
    public  static void set(){
        String at= ConnectWeChatServlet.getAccessToken();
        String url="https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN";
        url=url.replace("ACCESS_TOKEN",at);
        String data="{\n" +
                "    \"industry_id1\":\"1\",\n" +
                "    \"industry_id2\":\"21\"\n" +
                "}";
        String result=Joke.post(url,data);
        System.out.println(result);
    }
    public static void get(){
        String at= ConnectWeChatServlet.getAccessToken();
        String url="https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=ACCESS_TOKEN";
        url=url.replace("ACCESS_TOKEN",at);
        System.out.println("url:"+url);
//        Joke.get(url);
        try {
            byte[] bytes=Joke.get(url).getBytes("UTF-8");
            String sb =new String(bytes,DEF_CHATSET);
            System.out.println("a:"+sb);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    /**
     *发送模板
     */
    public static void sendTemplateMessage(String opneid){
        String url="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
        url=url.replace("ACCESS_TOKEN",ConnectWeChatServlet.getAccessToken());
        System.out.println(url);
        Calendar cal=Calendar.getInstance();
        int month=cal.get(Calendar.MONTH) +1;
        String data="{\n" +
                "           \"touser\":\""+opneid+"\",\n" +
                "           \"template_id\":\"j0AXzm6A8jhgtk4nJbwagH5I2NHvjtmLSAefPr2wFbU\",\n" +
                "           \"url\":\"http://www.runwsh.com/chen/User/PersonalCenter.jsp\",  \n" +
                "           \"data\":{\n" +
                "                   \"first\": {\n" +
                "                       \"value\":\"项目申报成功！\",\n" +
                "                       \"color\":\"#00ff00\"\n" +
                "                   },\n" +
                "                   \"company\":{\n" +
                "                       \"value\":\"【项目投资监管平台】\",\n" +
                "                       \"color\":\"#000000\"\n" +
                "                   },\n" +
                "                   \"time\": {\n" +
                "                       \"value\":\"100,000,000元\",\n" +
                "                       \"color\":\"#ff0000\"\n" +
                "                   },\n" +
                "                   \"result\": {\n" +
                "\"value\":\""+cal.get(Calendar.YEAR)+"年"+ month+"月"+cal.get(Calendar.DATE)+"日"+"\",\n" +
                "                       \"color\":\"#000000\"\n" +
                "                   },\n" +
                "                   \"remark\":{\n" +
                "                       \"value\":\"通知已送达！\",\n" +
                "                       \"color\":\"#454545\"\n" +
                "                   }\n" +
                "           }\n" +
                "       }";
        String result=Joke.post(url,data);
        System.out.println(result);
    }

    /**
     * 发送通过项目的信息
     * @param opneid
     */
    public static void sendUnPassProjectMessage(String opneid){
        String url="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
        url=url.replace("ACCESS_TOKEN",ConnectWeChatServlet.getAccessToken());
        System.out.println(url);
        Calendar cal = Calendar.getInstance();
        int month=cal.get(Calendar.MONTH) + 1;
        String data="{\n" +
                "           \"touser\":\""+opneid+"\",\n" +
                "           \"template_id\":\"j0AXzm6A8jhgtk4nJbwagH5I2NHvjtmLSAefPr2wFbU\",\n" +
                "           \"url\":\"http://www.runwsh.com/chen/User/PersonalCenter.jsp\",  \n" +
                "           \"data\":{\n" +
                "                   \"first\": {\n" +
                "                       \"value\":\"项目审核不通过！\",\n" +
                "                       \"color\":\"#ff0000\"\n" +
                "                   },\n" +
                "                   \"company\":{\n" +
                "                       \"value\":\"【项目投资监管平台】\",\n" +
                "                       \"color\":\"#000000\"\n" +
                "                   },\n" +
                "                   \"time\": {\n" +
                "                       \"value\":\"再次重新申报项目吧！\",\n" +
                "                       \"color\":\"#ff0000\"\n" +
                "                   },\n" +
                "                   \"result\": {\n" +
                "\"value\":\""+cal.get(Calendar.YEAR)+"年"+month+"月"+cal.get(Calendar.DATE)+"日"+"\",\n" +
                "                       \"color\":\"#000000\"\n" +
                "                   },\n" +
                "                   \"remark\":{\n" +
                "                       \"value\":\"！\",\n" +
                "                       \"color\":\"#000000\"\n" +
                "                   }\n" +
                "           }\n" +
                "       }";
        String result=Joke.post(url,data);
        System.out.println(result);
    }

    /**
     *
     * @param opneid
     */
    public static void sendRegistTemplateMessage(String opneid){
        String url="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
        url=url.replace("ACCESS_TOKEN",ConnectWeChatServlet.getAccessToken());
        System.out.println(url);
        Calendar cal = Calendar.getInstance();
        int month=cal.get(Calendar.MONTH) +1;
        String data="{\n" +
                "           \"touser\":\""+opneid+"\",\n" +
                "           \"template_id\":\"j0AXzm6A8jhgtk4nJbwagH5I2NHvjtmLSAefPr2wFbU\",\n" +
                "           \"url\":\"http://www.runwsh.com/chen/User/PersonalCenter.jsp\",  \n" +
                "           \"data\":{\n" +
                "                   \"first\": {\n" +
                "                       \"value\":\"注册成功！\",\n" +
                "                       \"color\":\"#00ff00\"\n" +
                "                   },\n" +
                "                   \"company\":{\n" +
                "                       \"value\":\"【项目投资监管平台】\",\n" +
                "                       \"color\":\"#000000\"\n" +
                "                   },\n" +
                "                   \"time\": {\n" +
                "                       \"value\":\"快进入个人中心吧\",\n" +
                "                       \"color\":\"#ff0000\"\n" +
                "                   },\n" +
                "                   \"result\": {\n" +
                "\"value\":\""+cal.get(Calendar.YEAR)+"年"+month+"月"+cal.get(Calendar.DATE)+"日"+"\",\n" +
                "                       \"color\":\"#000000\"\n" +
                "                   },\n" +
                "                   \"remark\":{\n" +
                "                       \"value\":\"！\",\n" +
                "                       \"color\":\"#000000\"\n" +
                "                   }\n" +
                "           }\n" +
                "       }";
        String result=Joke.post(url,data);
        System.out.println(result);
    }

    /**
     *
     * @param opneid
     */
    public static void PasssendTemplateMessage(String opneid){
        String url="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
        url=url.replace("ACCESS_TOKEN",ConnectWeChatServlet.getAccessToken());
        System.out.println(url);
        Calendar cal = Calendar.getInstance();
        int month=cal.get(Calendar.MONTH) +1;
        String data="{\n" +
                "           \"touser\":\""+opneid+"\",\n" +
                "           \"template_id\":\"j0AXzm6A8jhgtk4nJbwagH5I2NHvjtmLSAefPr2wFbU\",\n" +
                "           \"url\":\"http://www.runwsh.com/chen/User/PersonalCenter.jsp\",  \n" +
                "           \"data\":{\n" +
                "                   \"first\": {\n" +
                "                       \"value\":\"项目审核成功！\",\n" +
                "                       \"color\":\"#00ff00\"\n" +
                "                   },\n" +
                "                   \"company\":{\n" +
                "                       \"value\":\"【项目投资监管平台】\",\n" +
                "                       \"color\":\"#000000\"\n" +
                "                   },\n" +
                "                   \"time\": {\n" +
                "                       \"value\":\"用项目去证明你\",\n" +
                "                       \"color\":\"#ff0000\"\n" +
                "                   },\n" +
                "                   \"result\": {\n" +
                "\"value\":\""+cal.get(Calendar.YEAR)+"年"+month+"月"+cal.get(Calendar.DATE)+"日"+"\",\n" +
                "                       \"color\":\"#000000\"\n" +
                "                   },\n" +
                "                   \"remark\":{\n" +
                "                       \"value\":\"！\",\n" +
                "                       \"color\":\"#000000\"\n" +
                "                   }\n" +
                "           }\n" +
                "       }";
        String result=Joke.post(url,data);
        System.out.println(result);
    }
}
