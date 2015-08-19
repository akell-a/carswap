package com.carswap.dao;

import com.carswap.model.Points;
import com.carswap.model.User;

/**
 * Created by hackomotto on 01.08.15.
 */
public interface PointsDAO {
    Points getUserPoints(User user);

    void save(Points points);
}
