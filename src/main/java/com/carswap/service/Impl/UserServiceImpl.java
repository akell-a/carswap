package com.carswap.service.Impl;

import com.carswap.dao.PointsDAO;
import com.carswap.dao.UserDAO;
import com.carswap.model.Car;
import com.carswap.model.Points;
import com.carswap.model.User;
import com.carswap.service.UserService;
import com.carswap.util.enums.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

/**
 * Created by hackomotto on 09.08.15.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;
    @Autowired
    PointsDAO pointsDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void setPointsDAO(PointsDAO pointsDAO) {
        this.pointsDAO = pointsDAO;
    }

    public boolean isUserLogedin(Model model) {
        return false;
    }
    
    public boolean isUserRegistered(User user){
        return false;
    }

    public void registerUser(User user){
        userDAO.save(user);
    }

    public User getUserByEmail(String email){
        User userFromDB = userDAO.getUserByEmail(email);
        return userFromDB != null ? userFromDB : null;
    }

    //todo Gena
    public List<Car> getUserCars(User user){
        List<Car> list = userDAO.getCarsByUser(user);
        return list;
    }

    public boolean editPassword(String oldPassword, String newPassword, String email){
        User userFromDB = getUserByEmail(email);
        if(oldPassword.equals(userFromDB.getPassword())){
            userFromDB.setPassword(newPassword);
            userDAO.update(userFromDB);
        } else {
            return false;
        }
        return true;
    }

    public boolean editEmail(String oldEmail, String newEmail){
        User userFromDB = getUserByEmail(oldEmail);
        //checking if the new email is already in use
        boolean isNewEmailInUse = getUserByEmail(newEmail) != null;
        if(null != userFromDB && !isNewEmailInUse){
            userFromDB.setEmail(newEmail);
            userDAO.update(userFromDB);
        } else {
            return false;
        }
        return true;
    }

    public boolean editPoints(String email, Long pointsAmount, String operation){
        User userFromDB = getUserByEmail(email);
        if(null == userFromDB){
            return false;
        }
        Points points = userFromDB.getPoints();
        if(null == points){
            points = new Points();
            points.setUser(userFromDB);
            userFromDB.setPoints(points);
            //todo fix double save issue
            pointsDAO.save(points);
            userDAO.update(userFromDB);
        }

        if(operation.equalsIgnoreCase(Operation.PLUS.name())){
            points.setAmount(points.getAmount() + pointsAmount);
        } else if (operation.equalsIgnoreCase(Operation.MINUS.name())) {
            points.setAmount(points.getAmount() - pointsAmount);
        } else {
            return false;
        }
        pointsDAO.save(points);
        return true;
    }
}
