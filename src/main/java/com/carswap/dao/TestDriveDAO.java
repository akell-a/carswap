package com.carswap.dao;

import com.carswap.model.Car;
import com.carswap.model.TestDrive;
import com.carswap.model.User;

import java.util.Date;
import java.util.List;

/**
 * Created by hackomotto on 01.08.15.
 */
public interface TestDriveDAO {
    //name?
    List<TestDrive> getTestDrivesByProvider(User user);

    List<TestDrive> getTestDrivesByUser(User user);

    List<TestDrive> getTestDrivesByDate(Date date);

    List<TestDrive> getTestDriveByCar(Car car);
}
