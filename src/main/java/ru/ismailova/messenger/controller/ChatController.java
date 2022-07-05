package ru.ismailova.messenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ismailova.messenger.service.ChatService;

import java.util.List;

@Controller
public class ChatController {

    @GetMapping("/messenger")
    public String goChatting(@RequestParam(value = "userName") String userName, Model model) {
        model.addAttribute("userName", userName);
        return "chat";
    }


}
