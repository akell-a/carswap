package com.carswap.dao.impl;

import com.carswap.dao.EntityDAO;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.NonUniqueResultException;
import org.hibernate.criterion.Restrictions;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hackomotto on 09.08.15.
 */
@Repository
public abstract class EntityDAOImpl<T, ID extends Serializable> extends HibernateDaoSupport implements EntityDAO<T, ID> {

    protected Class<T> persistentClass;
    protected Class<ID> idClass;

    @SuppressWarnings({"unchecked"})
    protected EntityDAOImpl() {

        Class daoClass = getClass();

        while (!(daoClass
                .getGenericSuperclass() instanceof ParameterizedType) && EntityDAOImpl.class != daoClass) {
            daoClass = daoClass.getSuperclass();
        }

        persistentClass = (Class<T>) ((ParameterizedType) daoClass.getGenericSuperclass()).getActualTypeArguments()[0];
        idClass = (Class<ID>) ((ParameterizedType) daoClass.getGenericSuperclass()).getActualTypeArguments()[1];
    }


    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    public Class<ID> getIdClass() {
        return idClass;
    }

    protected Criteria getDefaultCriteria() {
        return getSessionFactory().openSession().createCriteria(getPersistentClass());
    }

    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.SUPPORTS)
    public T get(final ID entityId) {
        return (T) getSessionFactory().openSession().get(getPersistentClass(), entityId);
    }

    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.SUPPORTS)
    public T getFull(final ID entityId) {
        return get(entityId);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public T get(final ID entityId, final LockMode lock) {
        return getPersistentClass().cast(getSessionFactory().openSession().get(getPersistentClass(), entityId, lock));
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public Object get(final ID entityId, final Class persistClass) {
        return getSessionFactory().openSession().get(persistClass, entityId);
    }

    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.SUPPORTS)
    public T load(final ID entityId) {
        return (T) getSessionFactory().openSession().load(getPersistentClass(), entityId);
    }

    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.SUPPORTS)
    public T findEntityById(ID entityId) {
        return (T) getDefaultCriteria().
                add(Restrictions.idEq(entityId)).uniqueResult();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void save(final T entity) {
        getSessionFactory().openSession().saveOrUpdate(entity);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(final T entity) {
        getSessionFactory().openSession().delete(entity);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(ID entityID) {
        delete(load(entityID));
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public boolean isAttached(final T entity) {
        return getSessionFactory().openSession().contains(entity);
    }

    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.SUPPORTS)
    public void setReadOnly(final T entity, boolean readOnly) {

        T actualEntity = entity;

        // special processing for proxies needed - we should obtain actual entity
        if (entity instanceof HibernateProxy) {
            LazyInitializer li = ( (HibernateProxy) entity ).getHibernateLazyInitializer();
            if ( li.isUninitialized() ) {
                //if it is an uninitialized proxy, we can do nothing
                return;
            }
            else {
                //if it is initialized, get actual entity
                actualEntity = (T) li.getImplementation();
            }
        }

        getSessionFactory().openSession().setReadOnly(actualEntity, readOnly);
    }

    public static Object unique(final List list) throws NonUniqueResultException {
        int size = list.size();
        if (size == 0) return null;
        Object first = list.get(0);
        for (int i = 1; i < size; i++) {
            if (list.get(i) != first) {
                throw new NonUniqueResultException(list.size());
            }
        }
        return first;
    }

    /**
     * Check filed name. if contains "." then need alias
     *
     * @param fieldName field name
     * @return true if need alias
     */
    protected boolean isNeedAlias(String fieldName) {
        return fieldName != null && fieldName.indexOf('.') != -1;
    }

    /**
     * Get alias from field (name before ".")
     *
     * @param fieldName field name
     * @return alias name
     */
    protected String getAlias(String fieldName) {
        return fieldName.substring(0, fieldName.indexOf('.'));
    }

    protected String truncateFieldName(String fieldName) {
        String retval = fieldName;
        for (; retval.split("\\.").length > 2; ) {
            retval = retval.substring(retval.indexOf(".") + 1, retval.length());
        }
        return retval;
    }

    protected List<String> splitIntoPaths(String fieldName) {
        List<String> retval = new ArrayList<String>();
        String[] fieldNameParts = fieldName.split("\\.");
        StringBuilder alias = new StringBuilder();
        int aliasesCount = fieldNameParts.length - 1;
        for (int i = 0; i < aliasesCount; i++) {
            alias.append(fieldNameParts[i]);
            retval.add(alias.toString());
            alias.append(".");
        }
        return retval;
    }
}
