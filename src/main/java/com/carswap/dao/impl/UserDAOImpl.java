package com.carswap.dao.impl;

import com.carswap.dao.UserDAO;
import com.carswap.model.Car;
import com.carswap.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by hackomotto on 01.08.15.
 */

public class UserDAOImpl extends EntityDAOImpl<User, Long> implements UserDAO {

    @Transactional(propagation = Propagation.SUPPORTS)
    public User getUserByName(User user) {
        return (User) getSessionFactory().openSession().createQuery("select u from User u where u.name = :name " +
                "and u.secondName = :secondName " +
                "and u.birthDate = :birthDate")
                .setString("name", user.getName())
                .setString("secondName", user.getSecondName())
                .setDate("birthDate", user.getBirthDate())
                .uniqueResult();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public User getUserByEmail(String email) {
        Session session = getSessionFactory().openSession();
        Transaction tx;
        User user = null;
        try {
            tx = session.beginTransaction();
            user = (User) session.createQuery("select u from User u where u.email = :email")
                    .setString("email", email)
                    .uniqueResult();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return user;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Car> getCarsByUser(User user) {
        Query query = getSessionFactory().openSession().createQuery("select c " +
                "   from Car as c" +
                "   join c.user as us" +
                "   where user = :user");
        query.setEntity("user", user);
        return query.list();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> getAllUsers() {
        Query query = getSessionFactory().openSession().createQuery("select u " +
                "   from User as u");
        return query.list();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void changePassword(User user, String newPassword) {

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void changePhone(User user, String newPhone) {

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void changeEmail(User user, String newEmail) {

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void changeLocation(User user, String newLocation) {

    }

//    @Transactional(propagation = Propagation.SUPPORTS)
//    public void insert(User user) {
//        getSessionFactory().openSession().saveOrUpdate(user);
//    }

//    @Transactional(propagation = Propagation.SUPPORTS)
//    public Object merge(User user) {
//        return getSessionFactory().openSession().merge(user);
//    }
//
//    @Transactional(propagation = Propagation.SUPPORTS)
//    public void update(User user){
//        Session session = getSessionFactory().openSession();
//        Transaction tx;
//        try {
//            tx = session.beginTransaction();
//            session.update(user);
//            tx.commit();
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        finally {
//            session.close();
//        }
//    }
}
