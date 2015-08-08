package com.carswap.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by hackomotto on 01.08.15.
 */
@Entity
@Table(name = "cars")
public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "car_name")
    String name;

    @Column(name = "car_type")
    String type;

    @OneToOne(fetch = FetchType.LAZY)
    @Column(name = "user_id")
    User user;

    public Car() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
