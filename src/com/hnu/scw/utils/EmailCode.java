package com.hnu.scw.utils;

public class EmailCode {
    private String code;
    private long expired;

    public EmailCode(String code, long expired) {
        super();
        this.code= code;
        this.expired = expired;
    }
    public boolean IsExpired(){
       return System.currentTimeMillis()>expired;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getExpired() {
        return expired;
    }

    public void setExpired(long expired) {
        this.expired = expired;
    }
}
