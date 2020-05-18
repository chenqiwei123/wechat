package com.hnu.scw.utils;

public class AccessToken {
    private String accessToken;
    private String access_token;
    private long expireTime1;
    private long expireTime2;
    private String refresh_token;

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public AccessToken(String accessToken, String expireIn) {
        super();
        this.accessToken = accessToken;
        expireTime1=System.currentTimeMillis()+Integer.parseInt(expireIn)*1000;
    }
    public AccessToken(String access_token, String expireIn,String refresh_token) {
        super();
        this.refresh_token=refresh_token;
        this.access_token = access_token;
        expireTime2=System.currentTimeMillis()+Integer.parseInt(expireIn)*1000;
    }
    //    判断token是否过期
    public boolean isExpired1(){
        return System.currentTimeMillis()>expireTime1;
    }
    public boolean isExpired2(){
        return System.currentTimeMillis()>expireTime2;
    }
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public long getExpireTime1() {
        return expireTime1;
    }

    public void setExpireTime1(long expireTime1) {
        this.expireTime1 = expireTime1;
    }

    public long getExpireTime2() {
        return expireTime2;
    }

    public void setExpireTime2(long expireTime2) {
        this.expireTime2 = expireTime2;
    }
}
