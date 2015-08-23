package com.carswap.service;

import com.carswap.model.Car;

/**
 * Created by sigen on 23.08.2015.
 */
public interface CarService {
    public void addCar(Car car);

    public void editCar(Car car, long id);

    public void deleteCar(long id);
}
