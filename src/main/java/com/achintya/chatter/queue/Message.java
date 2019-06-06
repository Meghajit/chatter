package com.achintya.chatter.queue;

import com.achintya.chatter.user.User;

import java.sql.Timestamp;

public class Message {
    private String message;
    private User user;
    private Timestamp sentDate;

    public Message(String message, User user, Timestamp sentDate) {
        this.message = message;
        this.user = new User(user.getId(), user.getFirstName(), user.getLastName());
        this.sentDate = sentDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getSentDate() {
        return sentDate;
    }

    public void setSentDate(Timestamp sentDate) {
        this.sentDate = sentDate;
    }
}
