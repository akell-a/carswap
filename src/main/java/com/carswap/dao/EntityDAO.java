package com.carswap.dao;

import org.hibernate.LockMode;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hackomotto on 09.08.15.
 */
public interface EntityDAO<T, ID extends Serializable> {
    //Fields in interfaces are automatically public static final, and methods are public abstract. Classes or interfaces nested in an interface are automatically public and static (all nested interfaces are automatically static)
    Class<T> getPersistentClass();

    Class<ID> getIdClass();

    T get(final ID entityId);

    T getFull(final ID entityId);

    T get(final ID entityId, final LockMode lock);

    T load(final ID entityId);

    Object get(final ID entityId, final Class persistClass);

    T findEntityById(ID entityId);

    T findEntityById(ID entityId, int revision);

    void save(final T entity);

    void delete(final T entity);

    void delete(final ID entityID);

    List<T> getAll();

    void setReadOnly(T entity, boolean readOnly);

    Long getNextSequenceValue(String sequenceName);

    List<Number> getRevisionNumbersForEntity(Class entityClass, Long entityId);

    boolean isAttached(T entity);

    Session getCurrentSession();

    Number getRevisionNumberForDate(java.util.Date date);
}
