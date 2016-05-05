package com.example.guest.chatapp.models;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guest on 5/5/16.
 */

@Parcel
public class Message {
    String title;
    String message;
    String author;
    String pushId;
    List<String> comments = new ArrayList<>();

    public Message() {}

    public Message(String message, String title, String author) {
        this.message = message;
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getUser() {
        return author;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

    public String getAuthor() {
        return author;
    }

}
