package com.carswap.dao.impl;

import com.carswap.dao.CarDAO;
import com.carswap.model.Car;
import com.carswap.model.TestDrive;
import com.carswap.model.User;
import com.carswap.util.HibernateUtils;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by sigen on 8/8/2015.
 */
public class CarDAOImpl implements CarDAO {
    public User getOwner(Car car) {
        return (User) HibernateUtils.getSession().createQuery("select u from User as u " +
                "join u.cars as c " +
                "where c = :car")
                .setEntity("car", car)
                .uniqueResult();
    }

    public List<TestDrive> getCarTestDrives(Car car) {
        Query query = HibernateUtils.getSession().createQuery("select td " +
                "   from TestDrive as td" +
                "   join td.c as c" +
                "   where c = :car");
        query.setEntity("car", car);
        return query.list();
    }

    public List<Car> getCarsByType(String type) {
        Query query = HibernateUtils.getSession().createQuery("select c " +
                "from Car as c " +
                "where c.type = :carType");
        query.setEntity("carType", type);
        return query.list();
    }
}
