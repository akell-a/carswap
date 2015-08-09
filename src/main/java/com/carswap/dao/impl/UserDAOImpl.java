package com.carswap.dao.impl;

import com.carswap.dao.UserDAO;
import com.carswap.model.Car;
import com.carswap.model.User;
import org.hibernate.Query;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hackomotto on 01.08.15.
 */
@Repository("userDao")
public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {

    public User getUserById(Long id) {
        return (User) getSessionFactory().openSession().createQuery("select u from User u where u.id = :id")
                .setLong("id", id)
                .uniqueResult();
    }

    public User getUserByName(User user) {
        return (User) getSessionFactory().openSession().createQuery("select u from User u where u.name = :name " +
                "and u.secondName = :secondName " +
                "and u.birthDate = :birthDate")
                .setString("name", user.getName())
                .setString("secondName", user.getSecondName())
                .setDate("birthDate", user.getBirthDate())
                .uniqueResult();
    }

    public List<Car> getCarsByUser(User user) {
        Query query = getSessionFactory().openSession().createQuery("select c " +
                "   from Car as c" +
                "   join c.user as us" +
                "   where user = :user");
        query.setEntity("user", user);
        return query.list();
    }

    public List<User> getAllUsers() {
        Query query = getSessionFactory().openSession().createQuery("select u " +
                "   from User as u");
        return query.list();
    }

    public void insert(User user) {
        getSessionFactory().openSession().saveOrUpdate(user);
    }
}
