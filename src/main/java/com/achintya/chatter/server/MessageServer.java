package com.achintya.chatter.server;

import com.achintya.chatter.queue.Message;
import com.achintya.chatter.queue.MessageQueue;
import com.achintya.chatter.user.User;

import java.sql.Timestamp;
import java.util.List;

interface Server {
    List<Message> getMessages();

    Boolean sendMessage(String text);
}

public class MessageServer implements Server {
    private User caller;
    private Timestamp callerLastSeen;
    private User receiver;
    private MessageQueue queue;

    MessageServer(User caller, User receiver) {
        this.queue = new MessageQueue();
        this.caller = new User(caller.getId(), caller.getFirstName(), caller.getLastName());
        this.receiver = new User(receiver.getId(), receiver.getFirstName(), receiver.getLastName());
        callerLastSeen = new Timestamp(System.currentTimeMillis());
        System.out.println("Messaging service enabled between " + caller.getFirstName() + " and " + receiver.getFirstName() + ".");
    }

    @Override
    public List<Message> getMessages() {
        callerLastSeen = new Timestamp(System.currentTimeMillis());
        return queue.getMessages(callerLastSeen, receiver);
    }

    @Override
    public Boolean sendMessage(String text) {
        Message message = new Message(text, caller, new Timestamp(System.currentTimeMillis()));
        return queue.insertMessage(message);
    }

    public void finalize() {
        caller = null;
        receiver = null;
        callerLastSeen = null;
        queue = null;
        System.out.println("Terminated messaging service.");
    }
}
