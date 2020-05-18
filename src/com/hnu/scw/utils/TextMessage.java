package com.hnu.scw.utils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;
@XStreamAlias("xml")
public class TextMessage extends BaseMessage {
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        this.Content = content;
    }
    public TextMessage(Map<String,String> requestMap,String content){
        super(requestMap);
        this.Content=content;
        this.setMsgType("text");
    }


    @Override
    public String toString() {
        return "TextMessage{" +
                "Content='" + Content + '\'' +
                "} " + super.toString();
    }
}
