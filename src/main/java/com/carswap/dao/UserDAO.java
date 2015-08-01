package com.carswap.dao;

import com.carswap.model.Car;
import com.carswap.model.Points;
import com.carswap.model.User;

import java.util.List;

/**
 * Created by hackomotto on 01.08.15.
 */
public interface UserDAO {
    User getUserByName(String name);

    List<Car> getUserCars(User user);

    Points getUserPoints(User user);

    List<User> getAllUsers();
}
