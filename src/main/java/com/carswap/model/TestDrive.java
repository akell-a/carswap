package com.carswap.model;

import com.carswap.util.enums.CarStatus;
import com.carswap.util.enums.TestDriveStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by hackomotto on 01.08.15.
 */
@Entity
@Table(name = "testdrives")
public class TestDrive implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "testdrive_id")
    long id;

    @OneToOne(fetch = FetchType.LAZY)
    User user;

    @OneToOne(fetch = FetchType.LAZY)
    User provider;

    @OneToOne(fetch = FetchType.LAZY)
    Car car;

    @Column(name = "testdrive_date")
    Date date;

    @Column(name = "testdrive_status")
    @Enumerated(EnumType.STRING)
    TestDriveStatus testDriveStatus;

    public TestDrive() {
    }

    public long getId() {
        return id;
    }

    public TestDriveStatus getTestDriveStatus() {
        return testDriveStatus;
    }

    public void setTestDriveStatus(TestDriveStatus testDriveStatus) {
        this.testDriveStatus = testDriveStatus;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getProvider() {
        return provider;
    }

    public void setProvider(User provider) {
        this.provider = provider;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
