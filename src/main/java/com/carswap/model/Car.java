package com.carswap.model;
import com.carswap.util.enums.CarStatus;
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
    @Column(name = "car_id")
    long id;

    @Column(name = "car_name")
    String name;

    @Column(name = "car_type")
    String type;

    @ManyToOne(fetch = FetchType.LAZY)
    User user;

    @Column(name = "car_status")
    @Enumerated(EnumType.STRING)
    CarStatus carStatus;

    public Car() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CarStatus getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
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
