package com.carswap.controller;

import com.carswap.model.User;
import com.carswap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hackomotto on 09.08.15.
 */

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;

    @InitBinder
    public void registerInitBinder(WebDataBinder binder){
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.YYYY");
        CustomDateEditor birthdayEditor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, birthdayEditor);
    }

    @RequestMapping(value = "/processRegister.do", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") User user, BindingResult result){
        if(result.hasErrors()){
            //no error page
        }
        userService.registerUser();
        return "login";
    }

    @RequestMapping(value = "/processLogin.do", method = RequestMethod.POST)
    public String loginUser(@RequestParam String email, @RequestParam String password, HttpServletRequest request) throws Exception{
        User userFromDB = userService.getUserByEmail(email);
        if(null != userFromDB){
            if(userFromDB.getPassword().equals(password)){
                request.getSession().setAttribute("user", userFromDB);
                return "redirect:profile.do";
            }
        }

        throw new Exception("Wrong email or password");
    }

    @RequestMapping(value = "/logoutUser.do", method = RequestMethod.GET)
    public String logoutUser(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "redirect:main.do";
    }
}
