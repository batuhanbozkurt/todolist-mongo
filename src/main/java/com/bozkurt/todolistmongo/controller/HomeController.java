package com.bozkurt.todolistmongo.controller;

import com.bozkurt.todolistmongo.model.ListItem;
import com.bozkurt.todolistmongo.service.ListItemService;
import com.bozkurt.todolistmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ListItemService listItemService;

    @Autowired
    private UserService userService;

    @RequestMapping( value = {"/", "/index"})
    public String home(Model model) {

        List<ListItem> todolist = listItemService.findAll();
        model.addAttribute("todolist",todolist);
        return "index";
    }
}
