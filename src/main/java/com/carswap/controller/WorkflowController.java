package com.carswap.controller;

import com.carswap.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hackomotto on 15.08.15.
 */
@Controller
@RequestMapping("/")
public class WorkflowController {

    @RequestMapping(value = {"/", "main.do"}, method = RequestMethod.GET)
    public String showMainPage() {
        return "index";
    }

    @RequestMapping(value = "/profile.do", method = RequestMethod.GET)
    public String showProfile(HttpServletRequest request) {
        User userfromModel = (User) request.getSession().getAttribute("user");
        if(null != userfromModel){
            return "profile";
        } else {
            return "notRegistered";
        }
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public String showLogin() {
        return "login";
    }

    @RequestMapping(value = "/register.do", method = RequestMethod.GET)
    public String showRegister() {
        return "register";
    }

    @RequestMapping(value = "/changePassword.do", method = RequestMethod.GET)
    public ModelAndView showChangePassword(){
        ModelAndView modelAndView = new ModelAndView("editPage");
        return modelAndView.addObject("editType", "password");
    }

    @RequestMapping(value = "/editEmail.do", method = RequestMethod.GET)
    public ModelAndView showEditEmail(){
        ModelAndView modelAndView = new ModelAndView("editPage");
        return modelAndView.addObject("editType", "email");
    }

    @RequestMapping(value = "/editPoints.do", method = RequestMethod.GET)
    public ModelAndView showEditPoints(){
        ModelAndView modelAndView = new ModelAndView("editPage");
        return modelAndView.addObject("editType", "points");
    }
}
