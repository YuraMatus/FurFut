package com.furniturefuture.controller;

import com.furniturefuture.entity.Role;
import com.furniturefuture.entity.User;
import com.furniturefuture.repository.RoleRepository;
import com.furniturefuture.repository.UserRepository;
import com.furniturefuture.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static java.util.Collections.singleton;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }


    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())){
            model.addAttribute("passwordError", "UnMatched passwords");
            return "registration";
        }
        if (!userService.saveUser(userForm)){
            model.addAttribute("usernameError", "UserName exists");
            return "registration";
        }

        return "redirect:/";
    }
}