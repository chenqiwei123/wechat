package com.hnu.scw.utils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;
@XStreamAlias("xml")
public class imageMessage extends BaseMessage {
    @XStreamAlias("MediaId")
    private String mediaId;
    public imageMessage(Map<String, String> requestMap,String mediaId) {
        super(requestMap);
        this.setMsgType("image");
        this.mediaId=mediaId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
