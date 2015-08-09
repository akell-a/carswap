package com.carswap.dao.impl;

import com.carswap.dao.PointsDAO;
import com.carswap.model.Points;
import com.carswap.model.User;
import com.carswap.util.HibernateUtils;
import org.hibernate.Query;

/**
 * Created by hackomotto on 07.08.15.
 */
public class PointsDAOImpl implements PointsDAO {
    public Points getUserPoints(User user) {
        Query query = HibernateUtils.getSession().createQuery("select p " +
                "   from Points as p" +
                "   join p.user as us" +
                "   where us = :user");
        query.setEntity("user", user);
        return (Points) query.uniqueResult();
    }
}
