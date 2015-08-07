package com.carswap.controller;

import com.carswap.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by hackomotto on 01.08.15.
 */
@Controller
@RequestMapping("/")
public class TestController {
    @Autowired
    UserDAO userDAO;

@RequestMapping(value = "/", method = RequestMethod.GET)
    public String listEmployees(ModelMap model) {
        return "index";
    }
}
