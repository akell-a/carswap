package com.carswap.dao.impl;

import com.carswap.dao.CommentDAO;
import com.carswap.model.Car;
import com.carswap.model.Comment;
import com.carswap.model.Points;
import com.carswap.model.User;
import org.hibernate.Query;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sigen on 8/8/2015.
 */

public class CommentDAOImpl extends EntityDAOImpl<Comment, Long> implements CommentDAO {
    public List<Comment> getUserComments(User user) {
        Query query = getSessionFactory().openSession().createQuery("select c " +
                "   from Comments as c" +
                "   join c.user as u" +
                "   where u = :user");
        query.setEntity("user", user);
        return query.list();
    }
}
