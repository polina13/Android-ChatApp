package com.example.guest.chatapp.models;

/**
 * Created by Guest on 5/4/16.
 */
public class User {
    private String name;
    private String email;
    private int age;
    private String bio;

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
}

