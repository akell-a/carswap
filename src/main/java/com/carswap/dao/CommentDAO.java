package com.carswap.dao;

import com.carswap.model.Comment;
import com.carswap.model.User;

import java.util.List;

/**
 * Created by hackomotto on 01.08.15.
 */
public interface CommentDAO extends EntityDAO<Comment, Long>{
    List<Comment> getUserComments(User user);
}
