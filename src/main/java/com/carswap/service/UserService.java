package com.carswap.service;

import com.carswap.dao.impl.UserDAOImpl;
import com.carswap.model.Car;
import com.carswap.model.User;

import java.util.List;

/**
 * Created by hackomotto on 16.08.15.
 */
public interface UserService {

    public boolean isUserRegistered(User user);

    public void registerUser(User user);

    public User getUserByEmail(String email);

    public List<Car> getUserCars(User user);

    public boolean editPassword(String oldPassword, String newPassword, String email);

    public boolean editEmail(String oldEmail, String newEmail);

    public boolean editPoints(String email, Long points, String operation);

    public void setUserDAOImpl(UserDAOImpl userDAO);
}
