package User;

public class UserLoginInfo {
    private static String username;
    private static String Email;
    private static String password;
    private static String IndentityType;
    private static String openid;

    public UserLoginInfo(String username,String Email,String password,String IndentityType,String openid) {
        this.username=username;
        this.Email=Email;
        this.password=password;
        this.IndentityType=IndentityType;
        this.openid=openid;
    }

    public UserLoginInfo() {
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        UserLoginInfo.username = username;
    }

    public static String getEmail() {
        return Email;
    }

    public static void setEmail(String email) {
        Email = email;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        UserLoginInfo.password = password;
    }

    public static String getIndentityType() {
        return IndentityType;
    }

    public static void setIndentityType(String indentityType) {
        IndentityType = indentityType;
    }

    public static String getOpenid() {
        return openid;
    }

    public static void setOpenid(String openid) {
        UserLoginInfo.openid = openid;
    }
}
