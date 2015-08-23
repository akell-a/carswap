package com.carswap.service.Impl;

import com.carswap.dao.impl.CarDAOImpl;
import com.carswap.model.Car;
import com.carswap.service.CarService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hackomotto on 12.08.15.
 */
@Service
public class CarServiceImpl implements CarService{

    @Autowired
    CarDAOImpl carDAO;


    //todo Gena
    public void addCar(Car car){
        carDAO.addCar(car);
    };
    //todo Gena
    public void deleteCar(long id){
        carDAO.deleteCar(id);
    };
    //todo Gena
    public void editCar(Car car, long id){
        carDAO.editCar(car,id);
    };
}
