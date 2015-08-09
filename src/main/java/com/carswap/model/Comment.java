package com.carswap.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by hackomotto on 01.08.15.
 */
@Entity
@Table(name = "comments")
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    long id;

    @ManyToOne(fetch = FetchType.LAZY)
    User user;

    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    Date creationDate;

    String text;

    public Comment() {
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
