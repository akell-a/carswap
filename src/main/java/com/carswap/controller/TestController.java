package com.carswap.controller;

import com.carswap.dao.impl.UserDAOImpl;
import com.carswap.model.User;
import com.carswap.util.enums.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hackomotto on 01.08.15.
 */
@Controller
@RequestMapping("/")
public class TestController {
    @Autowired
    UserDAOImpl userDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listEmployees(ModelMap model) {
        List<User> userList = new ArrayList<User>();

        User user1 = new User();
        user1.setName("Artem");
        user1.setSecondName("Dmitriienko");
        userList.add(user1);

        User user2 = userDAO.getUserById(2L);
        if(null != user2){
            userList.add(user2);
        }

        User user3 = new User();
        user3.setName("John");
        user3.setSecondName("Doe");
        user3.setBirthDate(new Date());
        user3.setRole(Roles.ADMIN);
        user3.setCreationDate(new Date());

        userDAO.insert(user3);

        User user3FromDB = userDAO.getUserById(user3.getId());
        userList.add(user3FromDB);

        User user4 = new User();
        user4.setName("Vasia");
        user4.setSecondName("Pupkin");
        user4.setBirthDate(new Date());
        user4.setRole(Roles.ADMIN);
        user4.setCreationDate(new Date());
        userList.add(user4);

        model.addAttribute("userList", userList);

        return "index";
    }
}
