package com.carswap.dao.impl;

import com.carswap.dao.UserDAO;
import com.carswap.model.Car;
import com.carswap.model.User;
import com.carswap.util.HibernateUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hackomotto on 01.08.15.
 */
@Repository("userDao")
public class UserDAOImpl implements UserDAO {
    @Override
    public User getUserByName(User user) {
        return (User) HibernateUtils.getSession().createQuery("select u from User u where u.name = :name " +
                "and u.secondName = :secondName " +
                "and u.birthDate = :birthDate")
                .setString("name", user.getName())
                .setString("secondName", user.getSecondName())
                .setDate("birthDate", user.getBirthDate())
                .uniqueResult();
    }

    @Override
    public List<Car> getCarsByUser(User user) {
        Query query = HibernateUtils.getSession().createQuery("select c " +
                "   from Car as c" +
                "   join c.user as us" +
                "   where user = :user");
        query.setEntity("user", user);
        return query.list();
    }

    @Override
    public List<User> getAllUsers() {
        Query query = HibernateUtils.getSession().createQuery("select u " +
                "   from User as u");
        return query.list();
    }
}
