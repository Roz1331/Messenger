package ru.ismailova.messenger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.HashSet;
import java.util.Set;


public class ChatService {

    private final ApplicationContext context;
    private final ConsumerService consumerService;
    private final ProducerService producerService;

    private final Set<String> users = new HashSet<>();

    @Autowired
    public ChatService(ApplicationContext context, ConsumerService consumerService, ProducerService producerService) {
        this.context = context;
        this.consumerService = consumerService;
        this.producerService = producerService;
    }

    public boolean UserExist() {
        return false;
    }

    public void addUser(String name) {
        users.add(name);
        // TODO send message about new user
    }

    public void deleteUser(String name) {
        if(users.contains(name)) {
            users.remove(name);
        }
        // TODO send message about removed user
    }

}
