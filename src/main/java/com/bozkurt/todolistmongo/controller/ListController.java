package com.bozkurt.todolistmongo.controller;

import com.bozkurt.todolistmongo.model.User;
import com.bozkurt.todolistmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListController {

    @Autowired
    private UserService userService;

    @RequestMapping( value = {"/lists"})
    public String lists(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User loggedInUser = (User) authentication.getPrincipal();

        model.addAttribute("todolist",loggedInUser.getItems());
        return "index";
    }
}
