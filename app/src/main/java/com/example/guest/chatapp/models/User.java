package com.example.guest.chatapp.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guest on 5/4/16.
 */
public class User {
    private String name;
    private String email;
    private int age;
    private String bio;
    private String pushId;
    private List<Message> messages = new ArrayList<>();

    public User() {}

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBio() {
        return bio;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

}

