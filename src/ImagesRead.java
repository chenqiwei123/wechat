import com.baidu.aip.imageclassify.AipImageClassify;
import org.json.JSONObject;

import java.util.HashMap;

public class ImagesRead {
    public static final String APP_ID = "19208905";
    public static final String API_KEY = "bxLQARo3A0GGaFIeLHRQDift";
    public static final String SECRET_KEY = "EAATSwyL86QRNqjkAx40IrXpKuHrr7iX";

    public static void main(String[] args) {
        // ��ʼ��һ��AipImageClassify
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

        // ��ѡ�������������Ӳ���
//        client.setConnectionTimeoutInMillis(2000);
//        client.setSocketTimeoutInMillis(60000);

        // ��ѡ�����ô����������ַ, http��socket��ѡһ�����߾�������
//        client.setHttpProxy("proxy_host", proxy_port);  // ����http����
//        client.setSocketProxy("proxy_host", proxy_port);  // ����socket����

        // ���ýӿ�
        String path = "https://files.cnblogs.com/files/chenqiwei/myself.bmp";
        JSONObject res = client.objectDetect(path, new HashMap<String, String>());
        System.out.println(res.toString(2));

    }
}
