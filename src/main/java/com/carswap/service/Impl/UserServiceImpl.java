package com.carswap.service.Impl;

import com.carswap.dao.PointsDAO;
import com.carswap.dao.UserDAO;
import com.carswap.dao.impl.UserDAOImpl;
import com.carswap.model.Car;
import com.carswap.model.Points;
import com.carswap.model.User;
import com.carswap.service.UserService;
import com.carswap.util.HibernateUtil;
import com.carswap.util.enums.Operation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hackomotto on 09.08.15.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAOImpl;
    @Autowired
    PointsDAO pointsDAOImpl;

    public boolean isUserRegistered(User user){
        return false;
    }

    public void registerUser(){

    }

    public User getUserByEmail(String email){
        User userFromDB = userDAOImpl.getUserByEmail(email);

        return userFromDB != null ? userFromDB : null;
    }

    //todo Gena
    public List<Car> getUserCars(User user){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Car> list = userDAOImpl.getCarsByUser(user);
        session.close();

        return list;
    }

    public boolean editPassword(String oldPassword, String newPassword, String email){
        User userFromDB = getUserByEmail(email);
        if(oldPassword.equals(userFromDB.getPassword())){
            userFromDB.setPassword(newPassword);
            userDAOImpl.update(userFromDB);
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
            userDAOImpl.update(userFromDB);
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
            pointsDAOImpl.save(points);
            userDAOImpl.update(userFromDB);
        }

        if(operation.equalsIgnoreCase(Operation.PLUS.name())){
            points.setAmount(points.getAmount() + pointsAmount);
        } else if (operation.equalsIgnoreCase(Operation.MINUS.name())) {
            points.setAmount(points.getAmount() - pointsAmount);
        } else {

            return false;
        }
        pointsDAOImpl.save(points);

        return true;
    }

    public void setUserDAOImpl(UserDAOImpl userDAOImpl) {
        this.userDAOImpl = userDAOImpl;
    }
}
