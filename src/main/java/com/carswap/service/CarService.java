package com.carswap.service;

import com.carswap.dao.impl.CarDAOImpl;
import com.carswap.model.Car;
import com.carswap.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hackomotto on 12.08.15.
 */
@Service
public class CarService {

    @Autowired
    CarDAOImpl carDAO;


    //todo Gena
    void addCar(Car car){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(car);
        session.getTransaction().commit();
        HibernateUtil.shutdown();
    };
    //todo Gena
    void deleteCar(long id){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Car car = (Car)session.load(Car.class,id);
        session.delete(car);
        session.getTransaction().commit();
        HibernateUtil.shutdown();
    };
    //todo Gena
    //I don`t know what to return
    int editCar(Car car, long id){
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Car oldCar = (Car)session.load(Car.class,id);
            oldCar.setCarStatus(car.getCarStatus());
            oldCar.setName(car.getName());
            oldCar.setType(car.getType());
            oldCar.setUser(car.getUser());
            session.merge(oldCar);
            session.getTransaction().commit();
            HibernateUtil.shutdown();
            return 1;
        }catch(Exception e){
            return 0;
        }
    };
}
