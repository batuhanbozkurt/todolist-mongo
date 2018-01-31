package com.bozkurt.todolistmongo.controller;

import com.bozkurt.todolistmongo.dto.RegistrationDto;
import com.bozkurt.todolistmongo.model.User;
import com.bozkurt.todolistmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping( value = {"/register"}, method = RequestMethod.GET)
    public String registerPage(Model model) {
        RegistrationDto registrationDto = new RegistrationDto();
        model.addAttribute("user", registrationDto);
        return "registration";
    }

    @RequestMapping( value = {"/register"}, method = RequestMethod.POST)
    public String doRegistration( RegistrationDto registrationDto, Model model) {
        User user = new User();
        user.setEmail(registrationDto.getEmail());
        user.setName(registrationDto.getName());
        user.setSurname(registrationDto.getSurname());
        user.setPassword(bCryptPasswordEncoder.encode(registrationDto.getPassword()));

        userService.save(user);

        return "redirect:/index";
    }

    @RequestMapping( value = {"/login"}, method = RequestMethod.GET)
    public String loginPage(Model model) {
        return "login";
    }
}
