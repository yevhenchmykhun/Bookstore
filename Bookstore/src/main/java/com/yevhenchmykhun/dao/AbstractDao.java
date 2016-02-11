package com.yevhenchmykhun.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class AbstractDao<T, ID extends Serializable> {

    private Session session;
    private Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    protected AbstractDao() {
        persistentClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected Session getSession() {
        if (session == null)
            throw new IllegalStateException(
                    "Session has not been set on DAO before usage");
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    protected Class<T> getPersistentClass() {
        return persistentClass;
    }

    public T getEntityById(ID id) {
        return (T) getSession().get(persistentClass, id);
    }

    public void saveEntity(T entity) {
        getSession().persist(entity);
    }

    public void saveOrUpdateEntity(T entity) {
        getSession().saveOrUpdate(entity);
    }

    public void updateEntity(T entity) {
        getSession().update(entity);
    }

    public void deleteEntity(T entity) {
        getSession().delete(entity);
    }

    public void deleteEntityById(ID id) {
        T entity = getEntityById(id);
        if (entity != null) {
            deleteEntity(entity);
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        Query query = getSession().createQuery(
                "from " + persistentClass.getSimpleName());
        return (List<T>) query.list();
    }

    @SuppressWarnings("unchecked")
    protected List<T> findByCriteria(Criterion... criterion) {
        Criteria criteria = getSession().createCriteria(persistentClass);
        for (Criterion c : criterion) {
            criteria.add(c);
        }
        return (List<T>) criteria.list();
    }

    public int getNumberOfRows() {
        return ((Long) getSession().createQuery("select count(*) from " + persistentClass.getSimpleName()).iterate().next()).intValue();
    }

}
