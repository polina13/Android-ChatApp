package com.example.guest.chatapp.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guest on 5/5/16.
 */
public class Message {
    private String title;
    private String text;
    private String user;
    private List<String> comments = new ArrayList<>();

    public Message() {}

    public Message(String text, String title, String user) {
        this.text = text;
        this.title = title;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getUser() {
        return user;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }
}
