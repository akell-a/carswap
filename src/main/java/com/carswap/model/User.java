package com.carswap.model;

import com.carswap.util.enums.Roles;
import org.hibernate.annotations.Cascade;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by hackomotto on 01.08.15.
 */
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    long id;

    String name;

    @Column(name = "second_name")
    String secondName;

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    Date birthDate;

    @Enumerated(EnumType.STRING)
    Roles role;

    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    Date creationDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    List<Car> cars;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    List<Comment> comments;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    @JoinColumn(name = "user_id")
    Points points;

    public User() {
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Points getPoints() {
        return points;
    }

    public void setPoints(Points points) {
        this.points = points;
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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
