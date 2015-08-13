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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showMainPage() {
        return "index";
    }

    @RequestMapping(value = "/register.do", method = RequestMethod.POST)
    public String registerUser(){
        return "index";
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public String loginUser(){
        return "index";
    }
}
