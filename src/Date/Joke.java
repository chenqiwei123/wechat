package Date;

import java.io.*;
import java.net.*;
import java.util.Map;

public class Joke {

    /**
     *
     * @param strUrl 请求地址
     * @param params 请求参数
     * @param method 请求方法
     * @return  网络请求字符串
     * @throws Exception
     */
    public static final String DEF_CHATSET = "UTF-8";
    public static final int DEF_CONN_TIMEOUT = 30000;
    public static final int DEF_READ_TIMEOUT = 30000;
    public static String userAgent =  "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";
    public static String post(String url,String data){
        try {
            URL urlObject=new URL(url);
            URLConnection connection =  urlObject.openConnection();
            connection.setDoOutput(true);
            OutputStream os =connection.getOutputStream();
            os.write(data.getBytes(DEF_CHATSET));
            os.close();
            InputStream is =connection.getInputStream();
            byte[] b=new byte[1024];
            int len;
            StringBuilder sb1=new StringBuilder();
            while ((len=is.read(b))!=-1){
                sb1.append(new String(b,0,len));
            }
            return sb1.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String get(String url){
        URL urlObject= null;
        try {
            urlObject = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        URLConnection connection= null;
        try {
            connection = urlObject.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream is = null;
        try {
            is = connection.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("is:"+is);
            byte[] b=new byte[1024];
            int len = 0;
            StringBuilder sb=new StringBuilder();
            while (true){
                try {
                    if (!((len=is.read(b))!=-1)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sb.append(new String(b,0,len));
            }
        if (is!=null){
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    /**
     * 修改中文格式：目前只支持修改“GBK”和”ISO-8859-1“两种格式转为UTF-8
     * @param chart
     * @return
     */
//    public static String SaveChatSet(StringBuilder chart) throws Exception {
//        String str1="GBK";
//        String str2="ISO-8859-1";
//            if (chart.equals(new String(chart.toString().getBytes(str1),str1))){
//                String sb1=new String(chart.toString().getBytes(str1),DEF_CHATSET);
//                return sb1;
//            }
//            else if (chart.equals(new String(chart.toString().getBytes(str2),str2))){
//                String sb1=new String(chart.toString().getBytes(str2),DEF_CHATSET);
//                return sb1;
//            }
//            else
//                return chart.toString();
//    }


    /**
     *
     * @param strUrl 请求地址
     * @param params 请求参数
     * @param method 请求方法
     * @return  网络请求字符串
     * @throws Exception
     */
    /**
     *
     * @param strUrl 请求地址
     * @param params 请求参数
     * @param method 请求方法
     * @return  网络请求字符串
     * @throws Exception
     */
    public static String net(String strUrl, Map params,String method) throws Exception {
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        String rs = null;
        try {
            StringBuffer sb = new StringBuffer();
            if(method==null || method.equals("GET")){
                strUrl = strUrl+"?"+urlencode(params);
            }
            URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            if(method==null || method.equals("GET")){
                conn.setRequestMethod("GET");
            }else{
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
            }
            conn.setRequestProperty("User-agent", userAgent);
            conn.setUseCaches(false);
            conn.setConnectTimeout(DEF_CONN_TIMEOUT);
            conn.setReadTimeout(DEF_READ_TIMEOUT);
            conn.setInstanceFollowRedirects(false);
            conn.connect();
            if (params!= null && method.equals("POST")) {
                try {
                    DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                    out.writeBytes(urlencode(params));
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
            InputStream is = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sb.append(strRead);
            }
            rs = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return rs;
    }

    //将map型转为请求参数型
    public static String urlencode(Map<String,Object>data) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue()+"","UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }


}
