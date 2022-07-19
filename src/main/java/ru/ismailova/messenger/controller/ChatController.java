package ru.ismailova.messenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ismailova.messenger.entity.User;
import ru.ismailova.messenger.service.ChatService;

@Controller
public class ChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/messenger")
    public String goChatting(@RequestParam(value = "userName") String userName, Model model) {
        model.addAttribute("userName", userName);
        return "chat";
    }

    @GetMapping("/chat")
    public String go_Chatting(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = user.getUsername();
        model.addAttribute("userName", username);

        if (!chatService.userExists(username)) {
            chatService.addUser(username);
        }

        return "chat";
    }


}
