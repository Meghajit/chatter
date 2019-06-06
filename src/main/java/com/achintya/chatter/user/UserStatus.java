package com.achintya.chatter.user;

public class UserStatus {
    private User user;
    private boolean status;

    public UserStatus(User user, boolean status) {
        this.user = user;
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isActive() {
        return status;
    }

    public void setActive(boolean status) {
        this.status = status;
    }
}
