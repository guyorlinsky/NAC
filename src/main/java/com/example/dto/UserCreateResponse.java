package com.example.dto;

import com.example.models.User;

public class UserCreateResponse {
    private User user = null;

    public UserCreateResponse() {
    }

    public UserCreateResponse(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public UserCreateResponse setUser(User user) {
        this.user = user;
        return this;
    }
}
