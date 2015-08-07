package com.carswap.dao;

import com.carswap.model.Car;
import com.carswap.model.User;

import java.util.List;

/**
 * Created by hackomotto on 01.08.15.
 */
public interface UserDAO {
    User getUserByName(User user);

    List<Car> getCarsByUser(User user);

    List<User> getAllUsers();
}
