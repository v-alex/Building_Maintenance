package com.example.orgershov.building.Classes;

import java.io.Serializable;

/**
 * Created by alex-ks53 on 8/3/2016.
 */
public class Message implements Serializable {
    static private int messageID;
    private String content;
    private String fromUser;
    private String toUser;
    public Message(){};

    /**
     *
     * @param content
     * @param fromUser
     * @param toUser
     */
    public Message(String content,String fromUser,String toUser){
        setContent(content);
        setFromUser(fromUser);
        setToUser(toUser);

    };
    public Message(int ID,String content,String fromUser,String toUser){
        setContent(content);
        setFromUser(fromUser);
        setToUser(toUser);

        messageID=ID;
    };

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFromUser(){
        return fromUser;
    }

    public void setFromUser(String fromUser){
        this.fromUser= fromUser;
    }

    public String getToUser(){
        return this.toUser;
    }

    public void setToUser(String ToUser){
        this.toUser=ToUser;
    }

    public int getMessageID() {
        return messageID;
    }

}
