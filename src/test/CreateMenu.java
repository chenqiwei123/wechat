package test;

import Date.Joke;
import WechatServlet.ConnectWeChatServlet;
import com.hnu.scw.utils.Button;
import com.hnu.scw.utils.PhotoOrAlbumButton;
import com.hnu.scw.utils.SubButton;
import com.hnu.scw.utils.ViewButton;
import net.sf.json.JSONObject;
import org.apache.commons.codec.net.URLCodec;

import java.io.IOException;
import java.text.ParseException;

public class CreateMenu {
    public static final String APP_ID = "18403278";
    public static final String API_KEY = "KiybGkwKuUDRxZTsGwT8XANd";
    public static final String SECRET_KEY ="rV753DCEGUTKkyCaqIQce45lKrOhfZVW";
    private static URLCodec jwths256;

    public static void main(String[] args) {
        //设置代理
        System.getProperties().setProperty("http.proxyHost", "www.runwsh.com");
        System.getProperties().setProperty("http.proxyPort", "8080");
        Button btn =new Button();
        SubButton sb0=new SubButton("阳光政务");
        sb0.getSub_button().add(new ViewButton("平台简介","http://www.tzxm.gov.cn/index.html"));
        sb0.getSub_button().add(new ViewButton("政策法规","http://www.tzxm.gov.cn/flfg/index.html"));
        sb0.getSub_button().add(new ViewButton("办事指南","https://www.tzxm.gov.cn:8081/tzxmspweb/tzxmweb/pages/afgw/itemsortguide/projectCatalogSearch.jsp"));
        sb0.getSub_button().add(new ViewButton("公示信息","https://www.tzxm.gov.cn:8081/tzxmspweb/tzxmweb/pages/portal/publicinformation/examine_new.jsp"));
        sb0.getSub_button().add(new ViewButton("申报数据","https://www.tzxm.gov.cn:8081/tzxmspweb/evaluateinfo.do?method=searchrovinceEvaluateList&htmlSrc=2&orderFlg=2"));
        btn.getButton().add(sb0);
        SubButton sb1=new SubButton("我的平台");
        sb1.getSub_button().add(new ViewButton("进度查询","http://www.tzxm.gov.cn/index.html"));
        sb1.getSub_button().add(new ViewButton("报送建设","http://www.tzxm.gov.cn/flfg/index.html"));
        sb1.getSub_button().add(new ViewButton("我的空间","https://www.tzxm.gov.cn:8081/tzxmspweb/tzxmweb/pages/afgw/itemsortguide/projectCatalogSearch.jsp"));
        sb1.getSub_button().add(new ViewButton("个人中心","https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxcea26c733963d889&redirect_uri=http://www.runwsh.com/chen/agreeMe&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect"));
        sb1.getSub_button().add(new PhotoOrAlbumButton("文件按钮","32"));
        btn.getButton().add(sb1);
        SubButton sb=new SubButton("平台服务");
        sb.getSub_button().add(new ViewButton("申报指引","http://www.tzxm.gov.cn/bsdt/declareguide/index.html"));
        sb.getSub_button().add(new ViewButton("地方导航","http://www.tzxm.gov.cn/all_links.html"));
        sb.getSub_button().add(new ViewButton("材料下载","http://www.tzxm.gov.cn/xzzq/index.html"));
        sb.getSub_button().add(new ViewButton("联系客服","http://wpa.qq.com/msgrd?v=3&uin=3624026656&site=qq&menu=yes"));
        sb.getSub_button().add(new ViewButton("平台动态","http://www.tzxm.gov.cn/xwzx/index.html"));
        btn.getButton().add(sb);
        JSONObject jsonObject= JSONObject.fromObject(btn);
        System.out.println("菜单结构："+jsonObject);
//        String url="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
//        String url1=url.replace("ACCESS_TOKEN", ConnectWeChatServlet.getAccessToken());
//        System.out.println("ACCESS_TOKEN:"+ConnectWeChatServlet.getAccessToken());
//        String result= Joke.post(url1,jsonObject.toString());
//        System.out.println("result:"+result);
//        //上传图片和下载图片
//        String path = "C:\Users\RunWsh\Desktop\(5).jpg";
//        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
//        System.out.println(res.toString(2));
        /**
         * 发送信息通知模板
         */
        String at= ConnectWeChatServlet.getAccessToken();
        System.out.println("at:"+at);
        String url="https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN";
        url=url.replace("ACCESS_TOKEN",at);
        System.out.println("url:"+url);
        String data="{\n" +
                "    \"industry_id1\":\"1\",\n" +
                "    \"industry_id2\":\"4\"\n" +
                "}";
        String result= Joke.post(url,data);
        System.out.println(result);
//        TemplateMessageManager.sendTemplateMessage();
        /**
         * 项目法人的文件上传
         */
//        System.out.println(ConnectWeChatServlet.getAccessToken());
//            String file="C:\\Users\\RunWsh\\Desktop\\(5).jpg";
//            String type="image";
//            String result1= ConnectWeChatServlet.download(file,type);
//            System.out.println("result"+result1);
//            ConnectWeChatServlet.getOrCodeTicket();
//        String url="https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
//        url=url.replace("APPID","wxcea26c733963d889").replace("REDIRECT_URI","http://www.chenqiwei.xyz/chen/agreeMe").replace("SCOPE","snsapi_userinfo");
//        System.out.println("url:"+url);
//        String ss= Joke.get(url);
//        System.out.println("urlResult:"+ss);
        ///
//        String url="https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
//        url=url.replace("APPID","wxcea26c733963d889").replace("SECRET","e0d4867f02ecff50780971ec9698f5d4").replace("CODE","0713sYWt17xgKg0bMQTt1Z77Xt13sYWP");
//        String result= Joke.get(url);
//        System.out.println("result:"+result);
//        JSONObject jsonObject2=JSONObject.fromObject(result);
//        String accessToken=jsonObject2.getString("access_token");
//        String openid=jsonObject2.getString("openid");
//        UserInfoDao.AddUser(openid,0);
//        System.out.println("result:"+result);
//        url=" https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
//        url=url.replace("ACCESS_TOKEN",accessToken).replace("OPENID",openid);
//        String result2=Joke.get(url);
//        System.out.println("result2:"+result2);
//        String nickname=jsonObject2.getString("nickname");
//        String sex=jsonObject2.getString("sex");
//        String location=jsonObject2.getString("province")+"省"+jsonObject2.getString("city")+"市";
//        String headimg=jsonObject2.getString("headimgurl");
//        response.sendRedirect("/WechatMS/User/PersonalCenter.jsp");
//        ServicePeople.AddService();
//        UserInfoDao.AddUser("o1u0W1c7PFJPdfTCGMuC8bI0bxCg",0);
//        System.out.println(System.currentTimeMillis()/1000);
//        UserInfoDao.AddUser("o1u0W1Ze4VWWZtOYqiqHCjszjOU0",0);
//        String url="https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxcea26c733963d889&secret=e0d4867f02ecff50780971ec9698f5d4&code=CODE&grant_type=authorization_code";

//        url=url.replace("CODE","021zFbUy0CF8Jb11v4Ty0ObnUy0zFbUs");
//        System.out.println("url:"+url);
//        String result= Joke.get(url);
//        JSONObject jsonObject=JSONObject.fromObject(result);
//        System.out.println("结果："+jsonObject);

//        UserInfoDao.Query("o1u0W1fCwDh4XNlfv2jeyIljdWDk","data");
//        try {
//            System.out.println(ConnectWeChatServlet.robotchat("山清水秀"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }

        /**
         * 发送post请求
         * @param url  路径
         * @param jsonObject  参数(json类型)
         * @param encoding 编码格式
         * @return
         * @throws ParseException
         * @throws IOException
         */

}
