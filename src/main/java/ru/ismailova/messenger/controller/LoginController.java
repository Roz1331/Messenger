package ru.ismailova.messenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ismailova.messenger.entity.User;
import ru.ismailova.messenger.repository.UserRepository;
import ru.ismailova.messenger.service.ChatService;

import javax.validation.Valid;

@Controller
public class LoginController {

    private ChatService chatService;
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public LoginController(ChatService chatService, UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.chatService = chatService;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
//        User user = new User();
//        user.setPasswordConfirm("confirmed");
//        model.addAttribute("userLoginForm", user);

        System.out.println("login get method");
        return "login";
    }

//    @PostMapping("/login")
//    public String loginUser(@RequestParam(value = "username") String username,
//                            @RequestParam(value = "password") String password) {
////        if(!chatService.userExists(userName)) {
////            chatService.addUser(userName);
////
////            return "redirect:/messenger?userName=" + userName;
////        }
//        System.out.println("login post method");
//        User userDB = userRepository.findByUsername(username);
//        if (userDB == null) return "login";
//
//        String encodedPass = bCryptPasswordEncoder.encode(password);
//
//        if (!userDB.getPassword().equals(encodedPass)) return "login";
//
//        return "redirect:/";
////        return "redirect:/messenger?userName=" + user.getUsername();
////        if(!chatService.userExists(username)) {
////            chatService.addUser(username);
////
////            return "redirect:/messenger?userName=" + username;
////        }
////
////        // TODO return some error message
////        return "login";
//    }
}
