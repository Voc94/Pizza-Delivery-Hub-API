package com.learning.pizzahubapi.api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping
    public String displayAllUsers(Model model){
        List<String> users = new ArrayList<>();
        users.add("Marius");
        users.add("Danutz");
        users.add("Cosmin");
        model.addAttribute("users",users);
        return "user/index";
    }
}
