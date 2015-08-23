package com.carswap.model;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by hackomotto on 01.08.15.
 */
@Entity
@Table(name="points")
public class Points implements Serializable {

    //no ID and getters and setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_id")
    long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User user;

    @Column
    long amount = 0;

    public long getId() {
        return id;
    }

    public Points() {
    }

    public Points(User user) {
        this.user = user;
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

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.valueOf(amount);
    }
}
