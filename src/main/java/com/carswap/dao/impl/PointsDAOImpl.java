package com.carswap.dao.impl;

import com.carswap.dao.PointsDAO;
import com.carswap.model.Points;
import com.carswap.model.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by hackomotto on 07.08.15.
 */
@Repository("points")
public class PointsDAOImpl extends EntityDAOImpl<Points, Long> implements PointsDAO {
    public Points getUserPoints(User user) {
        Query query = getSessionFactory().openSession().createQuery("select p " +
                "   from Points as p" +
                "   join p.user as us" +
                "   where us = :user");
        query.setEntity("user", user);
        return (Points) query.uniqueResult();
    }
}
