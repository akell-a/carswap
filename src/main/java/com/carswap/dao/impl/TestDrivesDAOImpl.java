package com.carswap.dao.impl;

import com.carswap.dao.TestDriveDAO;
import com.carswap.model.Car;
import com.carswap.model.TestDrive;
import com.carswap.model.User;
import com.carswap.util.HibernateUtils;
import org.hibernate.Query;

import java.util.Date;
import java.util.List;

/**
 * Created by sigen on 8/8/2015.
 */
public class TestDrivesDAOImpl implements TestDriveDAO{
    public List<TestDrive> getTestDrivesByProvider(User provider) {
        Query query = HibernateUtils.getSession().createQuery("select td " +
                "   from TestDrive as td" +
                "   where td.provider = :provider");
        query.setEntity("provider", provider);
        return query.list();
    }

    public List<TestDrive> getTestDrivesByUser(User user) {

        Query query = HibernateUtils.getSession().createQuery("select td " +
                "   from TestDrive as td" +
                "   where td.user = :user");
        query.setEntity("user", user);
        return query.list();
    }

    public List<TestDrive> getTestDrivesByDate(Date date) {

        Query query = HibernateUtils.getSession().createQuery("select td " +
                "   from TestDrive as td" +
                "   where td.date = :date");
        query.setEntity("date", date);
        return query.list();
    }

    public List<TestDrive> getTestDriveByCar(Car car) {

        Query query = HibernateUtils.getSession().createQuery("select td " +
                "   from TestDrive as td" +
                "   where td.car = :car");
        query.setEntity("car", car);
        return query.list();
    }
}
