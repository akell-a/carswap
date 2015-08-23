package com.carswap.dao.impl;

import com.carswap.dao.CarDAO;
import com.carswap.model.Car;
import com.carswap.model.TestDrive;
import com.carswap.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by sigen on 8/8/2015.
 */

public class CarDAOImpl extends HibernateDaoSupport implements CarDAO {
    //todo check
    public User getCarOwner(Car car) {
        return (User) getSessionFactory().openSession().createQuery("select u from User as u " +
                "join u.cars as c " +
                "where c = :car")
                .setEntity("car", car)
                .uniqueResult();
    }

    public List<TestDrive> getCarTestDrives(Car car) {
        Query query = getSessionFactory().openSession().createQuery("select td " +
                "   from TestDrive as td" +
                "   join td.car as c" +
                "   where c = :car");
        query.setEntity("car", car);
        return query.list();
    }

    public List<Car> getCarsByType(String type) {
        Query query = getSessionFactory().openSession().createQuery("select c " +
                "from Car as c " +
                "where c.type = :carType");
        query.setEntity("carType", type);
        return query.list();
    }

    public String getCarStatus(Car car) {
        return null;
    }

    public void addCar(Car car) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(car);
        session.getTransaction().commit();
        session.close();
    }

    public int editCar(Car car, long id) {
        Session session = getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Car oldCar = (Car) session.load(Car.class, id);
            oldCar.setCarStatus(car.getCarStatus());
            oldCar.setName(car.getName());
            oldCar.setType(car.getType());
            oldCar.setUser(car.getUser());
            session.merge(oldCar);
            session.getTransaction().commit();
            session.close();
            return 1;
        } catch (Exception e){
            return 0;
        }
        finally {
            session.close();
        }
    }

    public void deleteCar(long id) {
        Session session = getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Car car = (Car) session.load(Car.class, id);
            session.delete(car);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
