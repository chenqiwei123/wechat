package WechatServlet;

import Date.Joke;
import com.alibaba.fastjson.JSON;
import com.hnu.scw.utils.*;
import com.thoughtworks.xstream.XStream;
import net.sf.json.JSONObject;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import static Date.Joke.net;

@WebServlet(name = "ConnectWeChatServlet")
public class ConnectWeChatServlet extends HttpServlet {
    public static final String DEF_CHATSET = "UTF-8";
    public static final String APP_ID = "18403278";
    public static final String API_KEY = "KiybGkwKuUDRxZTsGwT8XANd";
    public static final String SECRET_KEY = "rV753DCEGUTKkyCaqIQce45lKrOhfZVW";
    private static final String APPID="wxcea26c733963d889";
    private static final String APPSECRET="e0d4867f02ecff50780971ec9698f5d4";
    private static AccessToken accessToken;
    private static final String GET_TOKEN_URL="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    private static void getToken(){
        String url=GET_TOKEN_URL.replace("APPID",APPID).replace ("APPSECRET",APPSECRET);
        String tokenStr=Joke.get(url);
        JSONObject jsonObject=JSONObject.fromObject(tokenStr);
        String token=jsonObject.getString("access_token");
        String expiresIn=jsonObject.getString("expires_in");
        accessToken=new AccessToken(token,expiresIn);

    }
    private static void getToken1(){
        String refresh_token=accessToken.getRefresh_token();
        String url="https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=wxcea26c733963d889&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
        url=url.replace("REFRESH_TOKEN",refresh_token);
        String tokenStr=Joke.get(url);
        JSONObject jsonObject=JSONObject.fromObject(tokenStr);
        String access_token=jsonObject.getString("access_token");
        String expiresIn=jsonObject.getString("expires_in");
        accessToken=new AccessToken(access_token,expiresIn,refresh_token);
    }
    public static String getAccessToken(){
        if (accessToken==null||accessToken.isExpired1()){
            getToken();
        }
        return accessToken.getAccessToken();
    }
    public static String getAccessToken2(){
        if (accessToken.getAccess_token().equals("")||accessToken.isExpired2()){
            getToken1();
        }
        return accessToken.getAccessToken();
    }
    @Override
    /*
     * 接受微信服务器的消息
     * */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf8");
        Map<String,String> requestMap=ConnectWeChatServlet.parseRequest(request.getInputStream());
        String respXml =ConnectWeChatServlet.getResponse(requestMap);
        System.out.println("回复消息测试xml："+respXml);
        PrintWriter out =response.getWriter();
        out.print(respXml);
        out.flush();
        out.close();
        //准备回复的数据包
    }
    //用于处理所有事件的消息回复
    private static String getResponse(Map<String, String> requestMap) {
        BaseMessage msg=null;
        String msgType=requestMap.get("MsgType");
        switch (msgType){
            case "text":
                msg=dealTextMessage(requestMap);
                break;
            case "image":
                msg=dealImageMessage(requestMap);
                break;
            case "voice":
                msg=dealVoiceMessage(requestMap);
                break;
            case "video":
                msg=dealTextMessage(requestMap);
                break;
            case "shortvideo":
                msg=dealTextMessage(requestMap);
                break;
            case "location":
                msg=dealLocationMessage(requestMap);
                break;
            case "link":
                msg=dealLinkMessage(requestMap);
                break;
            case "event":
                msg=dealEventMessage(requestMap);
                break;
            default:
                msg=dealTextMessage(requestMap);
                break;
        }
        //把消息对象处理为xml数据包
        return DealMsg(msg);

    }

    private static BaseMessage dealLinkMessage(Map<String, String> requestMap) {
        String title=requestMap.get("Title");
        String Description=requestMap.get("Description");
        String Url=requestMap.get("Url");
        String msg="【链接标题】"+title+"\n"+
                "【链接描述】"+Description+"\n"+
                "【链接消息】"+Url+"\n";
        TextMessage tm =new TextMessage(requestMap,msg);
        return tm;
    }

    private static BaseMessage dealEventMessage(Map<String, String> requestMap) {
        TextMessage tm=null;
        String msg =requestMap.get("Event");
        if (msg.indexOf("subscribe")!=-1){
            String resp=Welcome();
            tm =new TextMessage(requestMap,resp);
        }
        return tm;

    }

    public static String robotchat(String msg) throws Exception {
        String APIKEY = "a7ffa2f749b14faf999a22fb0273cb7c";
        String question = msg;//这是上传给云机器人的问题
        //String INFO = URLEncoder.encode("北京今日天气", "utf-8");
        String INFO = URLEncoder.encode(question, "utf-8");
        String getURL = "http://www.tuling123.com/openapi/api?key=" + APIKEY + "&info=" + INFO;
        URL getUrl = new URL(getURL);
        HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
        connection.connect();
        // 取得输入流，并使用Reader读取
        BufferedReader reader = new BufferedReader(new InputStreamReader( connection.getInputStream(), "utf-8"));
        StringBuffer sb = new StringBuffer();
        String line = "";
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        // 断开连接
        connection.disconnect();
        System.out.println(sb);
        return sb.toString();

    }
    /**
     * 对msg处理
     * @param msg
     * @return
     */
    public static String DealMsg(BaseMessage msg){
        if (msg!=null){
            System.out.println("转换成xml格式："+beanToXml(msg));
            return beanToXml(msg);
        }
        else return null;
    }
    public static String Welcome(){
        return "感谢你的关注!\n如果有一天你离开了我，请记得我们相爱过！";
    }
    public static String beanToXml(BaseMessage msg) {
        XStream stream =new XStream();
        //把处理的Xstream注解类同微信服务器
        stream.processAnnotations(TextMessage.class);
        stream.processAnnotations(imageMessage.class);
        stream.processAnnotations(musicMessage.class);
        stream.processAnnotations(NewsMessage.class);
        stream.processAnnotations(videoMessage.class);
        stream.processAnnotations(voiceMessage.class);
        String xml =stream.toXML(msg);
        System.out.println("xml"+xml);
        return xml;
    }

    //处理文本消息
    private static BaseMessage dealTextMessage(Map<String, String> requestMap) {
        String msg =requestMap.get("Content");
        if (msg.indexOf("天气+")!=-1){
            msg=msg.replace("天气+","");
            String resp=Weather(msg);
            TextMessage tm =new TextMessage(requestMap,resp);
            return tm;
        }
        if (msg.equals("登录")){
            String url="https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
            url=url.replace("APPID","wxcea26c733963d889").replace("REDIRECT_URI","http://www.runwsh.com/chen/agreeMe").replace("SCOPE","snsapi_userinfo");
            msg="<a href=\""+url+"\">登录请击这里</a>";
            TextMessage tm =new TextMessage(requestMap,msg);
            return tm;
        }
        if(msg.equals("消息动态")){
            List<Article> articles=new ArrayList<>();
            articles.add(new Article("项目投资监管平台头条推荐","特朗普宣布暂停想世卫组织拨款，联合国秘书长表态！","https://dss3.baidu.com/9fo3dSag_xI4khGko9WTAnF6hhy/super/crop=144,0,1728,1080/sign=d190fab2ba4543a9e154a08c2326beb6/203fb80e7bec54e754583e58b4389b504fc26a3b.jpg","https://mp.weixin.qq.com/s?__biz=MjM5MjAxNDM4MA==&mid=2666309146&idx=1&sn=338c82dd3d13c42d30cf520e9041b1d0&scene=0"));
            NewsMessage newsMessage=new NewsMessage(requestMap,"1",articles);
            System.out.println("newMessage:"+newsMessage);
            return newsMessage;
        }
        if (msg.equals("客服")){
            String url1="http://wpa.qq.com/msgrd?v=3&uin=3624026656&site=qq&menu=yes";
            String aa="<a href=\""+url1+"\">联系客服点击这里</a>";
            TextMessage tm =new TextMessage(requestMap,aa);
            return tm;
        }
        if (msg.equals("帮助")){
            msg="【微信客服业务指导】\n" +
                    "1、成语查询  例如（成语：山清水秀）\n" +
                    "2、天气查询  (1、直接对机器人说地方的天气 2、发送：【例如】天气+南昌)\n" +
                    "3、语音聊天。\n" +
                    "4、上传图片回复该图片外网链接\n" +
                    "5、客服"+
                    "6、登录个人中心"+
                    "7、消息动态";
            TextMessage textMessage=new TextMessage(requestMap,msg);
            return textMessage;
        }
        if (msg.indexOf("成语：")!=-1){
            msg=msg.replace("成语：","");
        String resp=chat(msg);
        TextMessage tm =new TextMessage(requestMap,resp);
        return tm;
        }
        TextMessage tm = null;
        try {
            String aa=ConnectWeChatServlet.robotchat(msg);
            JSONObject jsonObject=JSONObject.fromObject(aa);
            tm=new TextMessage(requestMap,jsonObject.getString("text"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }
    //回复语音
    private static BaseMessage dealVoiceMessage(Map<String, String> requestMap){
        System.out.println("【语音服务器传过来的requestMap】"+requestMap);
        String Content=requestMap.get("Recognition");
        System.out.println("【语音内容获取识别】"+Content);
        requestMap.remove("MediaId");
        requestMap.remove("Format");
        requestMap.remove("Recognition");
        requestMap.put("Content",Content);
        System.out.println("【提交给服务器的requestMap】"+requestMap);
        return dealTextMessage(requestMap);
    }
    //回复图片
    private static BaseMessage dealImageMessage(Map<String, String> requestMap){
        String PicUrl=requestMap.get("PicUrl");
        // 初始化一个AipOcr
        TextMessage tm=new TextMessage(requestMap,PicUrl);
        return tm;
    }
    //回复位置信息
    private static BaseMessage dealLocationMessage(Map<String, String> requestMap){
        String Location_X=requestMap.get("Location_X");
        String Location_Y=requestMap.get("Location_Y");
        String Scale=requestMap.get("Scale");
        String Label=requestMap.get("Label");
        String Content="【地理位置维度】"+Location_X+"\n【地理位置经度】"+Location_Y+"\n【地图缩放大小】"+Scale+"\n【地理位置信息】"+Label;
        requestMap.remove("Location_X");
        requestMap.remove("Location_Y");
        requestMap.remove("Scale");
        requestMap.remove("Label");
        TextMessage tm =new TextMessage(requestMap,Content);
        return tm;
    }

    public static void main(String[] args) {
        Weather("南昌");
    }
    //查询天气api
    public static String Weather(String msg){
        String APPKEY="675f347d695a8236544c17095d970131";
        String result =null;
        String url ="http://op.juhe.cn/onebox/weather/query";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("cityname",msg);//要查询的城市，如：温州、上海、北京
        params.put("key","675f347d695a8236544c17095d970131");//应用APPKEY(应用详细页查询)
        params.put("dtype","");//返回数据的格式,xml或json，默认json

        try {
            result =Joke.net(url, params, "GET");
            HashMap hashMap= JSON.parseObject(result,HashMap.class);
            JSONObject object=JSONObject.fromObject(hashMap.get("result"));
            JSONObject check=JSONObject.fromObject(hashMap);
            JSONObject object1=JSONObject.fromObject(object.get("data"));
            JSONObject object2= JSONObject.fromObject(object1.get("realtime"));
            JSONObject object5= JSONObject.fromObject(object1.get("life"));
            JSONObject object6= JSONObject.fromObject(object5.get("info"));
            JSONObject object3= JSONObject.fromObject(object2.get("weather"));
            JSONObject object4= JSONObject.fromObject(object2.get("wind"));
            if(check.getInt("error_code")==0){
                String tq="【时间】" +object2.get("date")+"\n" +
                        "【城市】" +object2.get("city_name")+"\n" +
                        "【阴历】" +object2.get("moon")+"礼拜"+object2.get("week")+"\n" +
                        "【温度】"+object3.get("temperature")+"\n" +
                        "【湿度】"+object3.get("humidity")+"\n" +
                        "【天气】"+object3.get("info") +"\n" +
                        "【风向】"+object4.get("direct") +"\n" +
                        "【风力】"+object4.get("power")+"\n" +
                        "【建议】\n" +
                        "【运动】"+object6.get("yundong")+"\n" +
                        "【穿衣】"+object6.get("chuanyi")+"\n" +
                        "【洗车】"+object6.get("xiche")+"\n" +
                        "【钓鱼】"+object6.get("diaoyu")+"\n" +
                        "【空调】"+object6.get("kongtiao")+"\n" +
                        "【带伞】"+object6.get("daisan")+"\n" +
                        "【过敏】"+object6.get("guomin")+"\n" +
                        "【感冒】"+object6.get("ganmao")+"\n" +
                        "【紫外】"+object6.get("ziwaixian")+"\n" +
                        "【舒适】"+object6.get("shushidu");
                System.out.println(tq);
                return tq;
            }else{
                System.out.println(object.get("error_code")+":"+object.get("reason"));
                return "您输入的城市查询错误！请重新输入【 正确输入例如：北京天气 】";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "暂停服务！";
    }
    //查询成语故事来源
    private static String chat(String msg) {
        String APPKEY="217058a6c5fbd8fb05177dbf92332ea2";
        //1.根据成语查询详细信息
        String result =null;
        String url ="http://v.juhe.cn/chengyu/query";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("word",msg);//填写需要查询的汉字，UTF8 urlencode编码
        params.put("key",APPKEY);//应用APPKEY(应用详细页查询)
        params.put("dtype","");//返回数据的格式,xml或json，默认json
        try {
            System.out.println("将map封装的params:"+params);
            result =Joke.net(url, params, "GET");
            System.out.println("Joke返回数据："+result);
            JSONObject object = JSONObject.fromObject(result);
            System.out.println("发过来的数据返回json:"+object);
            if(object.getInt("error_code")!=0){
                System.out.println(object.get("result"));
                String resp="您输入的不是成语！请重新输入!";
                return resp;
            }else{
                System.out.println(object.get("error_code")+":"+object.get("reason"));
                String resp="【拼音】"+object.getJSONObject("result").getString("pinyin")+"\n" +
                        "【成语解释】"+object.getJSONObject("result").getString("chengyujs")+"\n" +
                        "【来源】"+object.getJSONObject("result").getString("from_")+"\n"+
                        "【造句】"+object.getJSONObject("result").getString("example")+"\n"+
                        "【引证解释】"+object.getJSONObject("result").getString("yinzhengjs")+"\n"+
                        "【同义词】"+object.getJSONObject("result").getString("tongyi")+"\n"+
                        "【翻译】"+object.getJSONObject("result").getString("fanyi");
                return resp;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }
    //接受微信服务器xml并解析map
    private static Map<String, String> parseRequest(ServletInputStream is) {
        Map<String,String> map=new HashMap<>();
        SAXReader reader =new SAXReader();
        try {
            Document document = reader.read(is);
            Element root =document.getRootElement();
            List<Element> elements=root.elements();
            for (Element e:elements){
                map.put(e.getName(),e.getStringValue());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 进行验证是否身份匹配
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        System.out.println(""+signature +"@"+timestamp +"$"+nonce +"^"+echostr);
        PrintWriter out = response.getWriter();
        if(com.hnu.scw.utils.CheckConnectUtils.checkConncetWithWeChat(signature,timestamp,nonce)){
            out.print(echostr);
        }
    }

    /**
     * 上传素材
     * @param path
     * @param type
     * @return
     */
    public static String upload(String path,String type){
        File file=new File(path);
        String url="https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
        url=url.replace("ACCESS_TOKEN",getAccessToken()).replace("TYPE",type);
        try {
            URL url1=new URL(url);
            //强转连接
            HttpURLConnection conn=(HttpURLConnection) url1.openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(true);
            //设置请求头信息
            conn.setRequestProperty("Connection","keep-alive");
            conn.setRequestProperty("Charset","utf8");
            String boundary ="-----"+System.currentTimeMillis();
            conn.setRequestProperty("Content-Type","multipart/form-data;boundary="+boundary);
            InputStream inputStream=new FileInputStream(file);
            OutputStream outputStream=conn.getOutputStream();
            StringBuilder sb=new StringBuilder();
            sb.append("--");
            sb.append(boundary);
            sb.append("\r\n");
            sb.append("Content-Disposition:form-data;name=\"media\";filename=\""+file.getName()+"\"\r\n");
            sb.append("content-type:application/octet-stream\r\n\r\n");
            outputStream.write(sb.toString().getBytes());
            System.out.println(sb.toString());
//            outputStream.flush();
//            outputStream.close();
            byte[] b=new byte[1024];
            int len;
            while ((len=inputStream.read(b))!=-1){
                outputStream.write(b,0,len);
            }
            String foot="\r\n--"+boundary+"--\r\n";
            outputStream.write(foot.getBytes());
            outputStream.flush();
            outputStream.close();
            InputStream is2=conn.getInputStream();
            StringBuilder resp=new StringBuilder();
            while ((len=is2.read(b))!=-1){
                resp.append(new String(b,0,len));
            }
            return resp.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 下载上传的素材
     * @param file
     * @param type
     * @return
     */
    public static String download(String file,String type){
        String result=ConnectWeChatServlet.upload(file,type);
        String downloadUrl="https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
        JSONObject jsonObject=JSONObject.fromObject(result);
        Object media_id=jsonObject.get("media_id");
        downloadUrl=downloadUrl.replace("MEDIA_ID",media_id.toString()).replace("ACCESS_TOKEN",getAccessToken());
        return downloadUrl;
    }

    /**
     * 获取二维码的ticket
     * @return
     */
    public static String getOrCodeTicket(){
        String at=getAccessToken();
        String url="https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="+at;
        String data=" {\"expire_seconds\": 600, \"action_name\": \"QR_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": \"小微真帅\"}}}";
        String result=Joke.post(url,data);
        String ticket=JSONObject.fromObject(result).getString("ticket");
        System.out.println("result:"+result);
        System.out.println("ticket:"+ticket);
        return ticket;
    }

    /**
     * 生成二维码图片的访问地址
     * @param ticket
     * @return
     */
    public static String UrlOrCodeTicket(String ticket){
        return "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="+ticket;
    }

    /**
     * 获取用户信息
     * @param openid
     * @return
     */
    public static String getUserInfo(String openid){
        String url="https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
        url=url.replace("ACCESS_TOKEN",getAccessToken()).replace("OPENID",openid);
        String result= null;
        try {
            result = Joke.get(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("result:"+ result);
        return result;
    }
//    public static String

}