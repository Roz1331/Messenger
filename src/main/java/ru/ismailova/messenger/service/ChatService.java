package ru.ismailova.messenger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChatService {

    private final ApplicationContext context;
    private final ProducerService producerService;

    private final Map<String, ConsumerService> users = new HashMap<>();

    @Autowired
    public ChatService(ApplicationContext context, ProducerService producerService) {
        this.context = context;
        this.producerService = producerService;
    }

    public boolean userExists(String userName) {
        return users.containsKey(userName);
    }

    public void addUser(String name) {
        users.put(name, context.getBean(ConsumerService.class));
        // TODO send message about new user
    }

    public void deleteUser(String name) {
        users.remove(name);
        // TODO send message about removed user
    }

    public void sendMessage(String userName, String message) {
        producerService.sendMessage(String.format("%s:%s", userName, message));
    }

    public List<String> getMessages(String userName) {
        return users.containsKey(userName) ? users.get(userName).getAllMessages() : new ArrayList<>();
    }
}
