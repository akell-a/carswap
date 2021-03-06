package com.carswap.dao;

import com.carswap.model.Car;
import com.carswap.model.User;

import java.util.List;

/**
 * Created by hackomotto on 01.08.15.
 */
public interface UserDAO extends EntityDAO<User, Long>{
    User getUserByName(User user);

    List<Car> getCarsByUser(User user);

    List<User> getAllUsers();

    void changePassword(User user, String newPassword);

    void changePhone(User user, String newPhone);

    void changeEmail(User user, String newEmail);

    void changeLocation(User user, String newLocation);

    User getUserByEmail(String email);

//    Object merge(User user);
//
//    void update(User user);
//
//    void insert(User user);

}
