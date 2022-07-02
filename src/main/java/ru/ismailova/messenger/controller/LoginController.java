package ru.ismailova.messenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ismailova.messenger.service.ChatService;

@Controller
public class LoginController {

    private ChatService chatService;

    @Autowired
    public LoginController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam(value = "userName") String userName, Model model) {
        if(!chatService.userExists(userName)) {
            chatService.addUser(userName);

            return "/messenger?user=" + userName;
        }

        // TODO return some error message
        return "login";
    }
}
