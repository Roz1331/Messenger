package ru.ismailova.messenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ismailova.messenger.service.ChatService;

import java.util.List;

@RestController
public class MessengerController {

    private ChatService chatService;

    @Autowired
    public MessengerController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("message/send")
    public void sendMessage(@RequestParam(value = "userName") String userName,
                            @RequestParam(value = "message") String message) {
        chatService.sendMessage(message);
    }

    @GetMapping("message/get")
    public List<String> getMessages(@RequestParam(value = "userName") String userName) {
        return chatService.getMessages(userName);
    }
}
