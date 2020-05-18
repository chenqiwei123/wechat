package HelpService;

import Date.Joke;
import WechatServlet.ConnectWeChatServlet;

public class ServicePeople {

    /**
     * 客服测试号没有开通，暂时开发不了
     */
    public static void AddService(){
        String url="https://api.weixin.qq.com/customservice/kfaccount/add?access_token=ACCESS_TOKEN";
        url=url.replace("ACCESS_TOKEN", ConnectWeChatServlet.getAccessToken());
        String data=" {\n" +
                "      \"kf_account\" : \"chenqiwei001@gh_fd720b58ce72\",\n" +
                "      \"nickname\" : \"wei001\"\n" +
                "   }";
        String result= Joke.post(url,data);
        System.out.println("result:"+result);
    }
}
