package com.achintya.chatter.queue;

import com.achintya.chatter.user.User;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MessageQueue {
    private List<Message> queue;

    public MessageQueue() {
        queue = new ArrayList<>();
    }

    public Boolean insertMessage(Message msg) {
        return queue.add(msg);
    }

    public List<Message> getMessages(Timestamp date, User user) {
        int i = 0;
        for (; queue.get(i).getUser().toEqual(user) && queue.get(i).getSentDate().before(date); i++) ;
        return queue.subList(i, queue.size() - 1);
    }
}
