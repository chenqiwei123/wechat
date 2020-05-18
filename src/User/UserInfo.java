package User;

public class UserInfo {
    private static String subscribe;
    private static String openid;
    private static String nickname;
    private static String sex;
    private static String city;
    private static String province;
    private static String country;
    private static String headimgurl;
    private static String unionid;

    public UserInfo(String subscribe, String openid, String nickname, String sex, String city,String province, String country, String headimgurl,String unionid) {
        this.subscribe=subscribe;
        this.openid=openid;
        this.nickname=nickname;
        this.sex=sex;
        this.unionid=unionid;
        this.city=city;
        this.province=province;
        this.country=country;
        this.headimgurl=headimgurl;
    }

    public UserInfo() {
    }

    public static String getUnionid() {
        return unionid;
    }

    public static void setUnionid(String unionid) {
        UserInfo.unionid = unionid;
    }

    public static String getSubscribe() {
        return subscribe;
    }

    public static void setSubscribe(String subscribe) {
        UserInfo.subscribe = subscribe;
    }

    public static String getOpenid() {
        return openid;
    }

    public static void setOpenid(String openid) {
        UserInfo.openid = openid;
    }

    public static String getNickname() {
        return nickname;
    }

    public static void setNickname(String nickname) {
        UserInfo.nickname = nickname;
    }

    public static String getSex() {
        return sex;
    }

    public static void setSex(String sex) {
        UserInfo.sex = sex;
    }

    public static String getCity() {
        return city;
    }

    public static void setCity(String city) {
        UserInfo.city = city;
    }

    public static String getProvince() {
        return province;
    }

    public static void setProvince(String province) {
        UserInfo.province = province;
    }

    public static String getCountry() {
        return country;
    }

    public static void setCountry(String country) {
        UserInfo.country = country;
    }

    public static String getHeadimgurl() {
        return headimgurl;
    }

    public static void setHeadimgurl(String headimgurl) {
        UserInfo.headimgurl = headimgurl;
    }

}
