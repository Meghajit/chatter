package com.achintya.chatter.server;

import com.achintya.chatter.user.User;
import com.achintya.chatter.user.UserStatus;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ServerSpawner {
    private static Set<MessageServer> serverHub;
    private static Set<UserStatus> users;

    static {
        serverHub = new HashSet<>();
        users = new HashSet<>();
    }

    public static List<User> seeLoggedInUsers() {
        List<User> activeUsers = new ArrayList<>();
        for (UserStatus user : users) {
            if (user.isActive()) {
                activeUsers.add(user.getUser());
            }
        }
        return activeUsers;
    }

    public static boolean login(User user) {
        return users.add(new UserStatus(user, true));
    }

    private static boolean createSession(User caller, User receiver) {
        if (users.contains(new UserStatus(caller, true)) && users.contains(new UserStatus(receiver, true))) {
            return serverHub.add(new MessageServer(caller, receiver));
        } else return false;
    }

    public static boolean destroySession(User caller, User receiver) {
        if (serverHub.contains(new MessageServer(caller, receiver))) {
            return serverHub.remove(new MessageServer(caller, receiver));
        } else return false;
    }

}
