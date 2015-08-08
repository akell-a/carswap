package com.carswap.dao;

import com.carswap.model.*;

import java.util.List;

/**
 * Created by hackomotto on 01.08.15.
 */
public interface CarDAO {
    User getOwner(Car car);
    //name ???
    List<TestDrive> getCarTestDrives(Car car);
    //parameter?
    List<Car> getCarsByType(String type);
}
