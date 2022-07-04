package ru.ismailova.messenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ismailova.messenger.service.ChatService;

@Controller
public class ChatController {

    private ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/messenger")
    public String goChatting(@RequestParam(value = "userName") String userName, Model model) {
        model.addAttribute("userName", userName);
        return "chat";
    }

    @GetMapping("message/send")
    public void sendMessage(@RequestParam(value = "userName") String userName,
                              @RequestParam(value = "message") String message) {
        chatService.sendMessage(message);
    }
}
