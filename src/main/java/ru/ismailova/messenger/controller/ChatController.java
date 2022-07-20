package ru.ismailova.messenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ismailova.messenger.entity.Role;
import ru.ismailova.messenger.entity.User;
import ru.ismailova.messenger.service.ChatService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
//        Set<Role> roles = user.getRoles();
//        boolean isAdmin = roles.stream()
//                .map(Role::getName)
//                .filter(item -> item.equals("ROLE_ADMIN")).toList().size() > 0;

//        List<Role> res = roles.stream()
//                .filter(role -> role.getName().equals("ROLE_ADMIN"))
//                .forEach(x -> x.getName()).toList();

//        model.addAttribute("isAdmin", isAdmin);

        if (!chatService.userExists(username)) {
            chatService.addUser(username);
        }

        return "chat";
    }

}
