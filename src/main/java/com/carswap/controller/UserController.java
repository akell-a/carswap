package com.carswap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by hackomotto on 09.08.15.
 */

@Controller
@RequestMapping("/")
public class UserController {

    @RequestMapping(value = {"/", "main.do"}, method = RequestMethod.GET)
    public String showMainPage() {
        return "index";
    }

    @RequestMapping(value = "/profile.do", method = RequestMethod.GET)
    public String showProfile() {
        return "profile";
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public String showLogin() {
        return "login";
    }

    @RequestMapping(value = "/register.do", method = RequestMethod.GET)
    public String showRegister() {
        return "register";
    }

    @RequestMapping(value = "/processRegister.do", method = RequestMethod.POST)
    public String registerUser(){
        return "login";
    }

    @RequestMapping(value = "/processLogin.do", method = RequestMethod.POST)
    public String loginUser(){
        return "login";
    }
}
