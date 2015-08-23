package com.carswap.controller;

import com.carswap.model.User;
import com.carswap.service.UserService;
import com.carswap.util.enums.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    UserService userServiceImpl;

    public static final String USER_MODEL = "user";


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
        userServiceImpl.registerUser(user);
        return "login";
    }

    @RequestMapping(value = "/processLogin.do", method = RequestMethod.POST)
    public String loginUser(@RequestParam String email, @RequestParam String password, HttpServletRequest request) throws Exception{
        User userFromDB = userServiceImpl.getUserByEmail(email);
        if(null != userFromDB){
            if(userFromDB.getPassword().equals(password)){
                request.getSession().setAttribute(USER_MODEL, userFromDB);

                return "redirect:profile.do";
            }
        }

        throw new Exception("Wrong email or password");
    }

    @RequestMapping(value = "/logoutUser.do", method = RequestMethod.GET)
    public String logoutUser(HttpServletRequest request){
        request.getSession().removeAttribute(USER_MODEL);

        return "redirect:main.do";
    }

    @RequestMapping(value = "/processChangePassword.do", method = RequestMethod.POST)
    public ModelAndView changePassword(@RequestParam String passwordOld, @RequestParam String passwordNew,
                                       HttpServletRequest request) throws Exception{
        User modelUser = (User) request.getSession().getAttribute(USER_MODEL);
        if(null != modelUser){
            ModelAndView modelAndView = new ModelAndView("editResult");
            boolean status = userServiceImpl.editPassword(passwordOld, passwordNew, modelUser.getEmail());
            String result = status ? "success" : "fail";
            modelAndView.addObject("result", result);

            return modelAndView;
        }

        throw new Exception();
    }

    @RequestMapping(value = "/processChangeEmail.do", method = RequestMethod.POST)
    public ModelAndView changeEmail(@RequestParam String newEmail, HttpServletRequest request) throws Exception{
        User modelUser = (User) request.getSession().getAttribute(USER_MODEL);
        if(null != modelUser){
            ModelAndView modelAndView = new ModelAndView("editResult");
            boolean status = userServiceImpl.editEmail(modelUser.getEmail(), newEmail);
            String result = status ? "success" : "fail";
            modelAndView.addObject("result", result);

            return modelAndView;
        }

        throw new Exception();
    }

    @RequestMapping(value = "/processAddPoints.do", method = RequestMethod.POST)
    public ModelAndView addPoints(@RequestParam Long points, @RequestParam String operation, HttpServletRequest request) throws Exception{
        User modelUser = (User) request.getSession().getAttribute(USER_MODEL);
        if(null == modelUser || !modelUser.getRole().equals(Roles.ADMIN)){
            throw new Exception();
        }

        ModelAndView modelAndView = new ModelAndView("editResult");
        boolean status = userServiceImpl.editPoints(modelUser.getEmail(), points, operation);
        String result = status ? "success" : "fail";
        modelAndView.addObject("result", result);
        return modelAndView;
    }

    public void setUserServiceImpl(UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }
}
