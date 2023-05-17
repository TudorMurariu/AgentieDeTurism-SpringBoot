package com.example.model;

import java.util.UUID;

public class User extends Entity<UUID> {
    private String userName;
    private String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.setId(UUID.randomUUID());
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + this.getId() + '\'' +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
