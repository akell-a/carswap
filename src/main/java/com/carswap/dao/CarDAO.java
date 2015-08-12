package com.carswap.dao;

import com.carswap.model.*;

import java.util.List;

/**
 * Created by hackomotto on 01.08.15.
 */
public interface CarDAO {
    User getCarOwner(Car car);

    List<TestDrive> getCarTestDrives(Car car);

    List<Car> getCarsByType(String type);

    String getCarStatus(Car car);

    void addCar(Car car);

    int editCar(Car car, long id);
}

