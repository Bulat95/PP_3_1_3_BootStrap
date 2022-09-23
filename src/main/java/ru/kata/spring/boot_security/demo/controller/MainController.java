package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private UserService userservice;

    @Autowired
    public MainController(UserService userService) {
        this.userservice = userService;
    }

    @GetMapping("/user")
    public String getUserPage(ModelMap model, Principal principal) {
        model.addAttribute("authUser", userservice.getUserByName(principal.getName()));
        return "user";
    }

    @GetMapping(value = {"/"})
    public String getLoginPage() {
        return "/login";
    }

}
