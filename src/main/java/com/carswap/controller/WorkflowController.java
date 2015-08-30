package com.carswap.controller;

import com.carswap.model.Car;
import com.carswap.model.User;
import com.carswap.service.CarService;
import com.carswap.service.Impl.UserServiceImpl;
import com.carswap.service.UserService;
import com.carswap.util.enums.CarStatus;
import com.carswap.util.enums.CarTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hackomotto on 15.08.15.
 */
@Controller
@RequestMapping("/")
public class WorkflowController {

    @Autowired
    CarService carService;

    @RequestMapping(value = {"/", "main.do"}, method = RequestMethod.GET)
    public String showMainPage() {
        return "index";
    }

    @RequestMapping(value = "/profile.do", method = RequestMethod.GET)
    public String showProfile(HttpServletRequest request) {
        User userFromModel = (User) request.getSession().getAttribute("user");
        if (null != userFromModel) {
            return "profile";
        } else {
            return "notRegistered";
        }
    }

    @RequestMapping(value = "/login.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String showLogin() {
        return "login";
    }

    @RequestMapping(value = "/register.do", method = RequestMethod.GET)
    public String showRegister() {
        return "register";
    }

    @RequestMapping(value = "/changePassword.do", method = RequestMethod.GET)
    public ModelAndView showChangePassword() {
        ModelAndView modelAndView = new ModelAndView("editPage");
        return modelAndView.addObject("editType", "password");
    }

    @RequestMapping(value = "/editEmail.do", method = RequestMethod.GET)
    public ModelAndView showEditEmail() {
        ModelAndView modelAndView = new ModelAndView("editPage");
        return modelAndView.addObject("editType", "email");
    }

    @RequestMapping(value = "/editPoints.do", method = RequestMethod.GET)
    public ModelAndView showEditPoints() {
        ModelAndView modelAndView = new ModelAndView("editPage");
        return modelAndView.addObject("editType", "points");
    }

    @RequestMapping(value = "/editCars.do", method = RequestMethod.GET)
    public ModelAndView showEditCars() {
        ModelAndView modelAndView = new ModelAndView("editPage");
        return modelAndView.addObject("editType", "cars");
    }

    @RequestMapping(value = "/processEditCars.do", method = RequestMethod.POST)
    public String editCar(@ModelAttribute("car") Car car, BindingResult result, HttpServletRequest request) {
        return "cars";
    }



    @RequestMapping(value = "/processAddCar.do", method = RequestMethod.POST)
    public String addCar(@ModelAttribute("car") Car car, BindingResult result, HttpServletRequest request) {
        User userFromModel = (User) request.getSession().getAttribute("user");
        car.setUser(userFromModel);
        carService.addCar(car);
        return "cars";
    }

    @RequestMapping(value = "/addCar.do", method = RequestMethod.GET)
    public String showAddCar() {
        return "addCar";
    }

    @InitBinder
    public void addCarInitBinder(WebDataBinder binder){

    }







}
