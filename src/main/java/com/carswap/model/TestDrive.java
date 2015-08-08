package com.carswap.model;

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
    long id;

    @OneToOne(fetch = FetchType.LAZY)
    @Column(name = "user_id")
    User user;

    @OneToOne(fetch = FetchType.LAZY)
    @Column(name = "provider_id")
    User provider;

    @OneToOne(fetch = FetchType.LAZY)
    @Column(name = "car_id")
    Car car;

    @Column(name = "testdrive_date")
    Date date;

    public TestDrive() {
    }

    public long getId() {
        return id;
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
