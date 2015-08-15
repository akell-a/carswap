package com.carswap.service;

import com.carswap.dao.impl.UserDAOImpl;
import com.carswap.model.Car;
import com.carswap.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hackomotto on 09.08.15.
 */

@Service
public class UserService {

    @Autowired
    UserDAOImpl userDAO;

    public boolean isUserRegistered(User user){
        return false;
    }

    public void registerUser(){

    }

    public User getUserByEmail(String email){
        User userFromDB = userDAO.getUserByEmail(email);
        return userFromDB != null ? userFromDB : null;
    }

    //todo Gena
    public List<Car> getUserCars(User user){
        return null;
    }
}
