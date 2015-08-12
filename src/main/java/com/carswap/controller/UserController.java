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

    @RequestMapping(value = "/register.do", method = RequestMethod.POST)
    public void registerUser(){

    }

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public void loginUser(){

    }
}
