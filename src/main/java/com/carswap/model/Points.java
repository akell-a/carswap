package com.carswap.model;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by hackomotto on 01.08.15.
 */
@Entity
@Table(name="points")
public class Points implements Serializable {
    @OneToOne(fetch = FetchType.LAZY)
    @Column(name = "user_id")
    User user;

    @Column
    long amount;
}
