package com.yevhenchmykhun.dao;

import com.yevhenchmykhun.util.HibernateUtil;
import org.hibernate.Session;

public class DaoFactory {

    public BookDao getBookDao() {
        return (BookDao) instantiateDao(BookDao.class);
    }

    public CategoryDao getCategoryDao() {
        return (CategoryDao) instantiateDao(CategoryDao.class);
    }

    public CustomerDao getCustomerDao() {
        return (CustomerDao) instantiateDao(CustomerDao.class);
    }

    public CustomerOrderDao getCustomerOrderDao() {
        return (CustomerOrderDao) instantiateDao(CustomerOrderDao.class);
    }

    public OrderedBookDao getOrderedBookDao() {
        return (OrderedBookDao) instantiateDao(OrderedBookDao.class);
    }

    private AbstractDao instantiateDao(Class clazz) {
        try {
            AbstractDao dao = (AbstractDao) clazz.newInstance();
            dao.setSession(getCurrentSession());
            return dao;
        } catch (Exception ex) {
            throw new RuntimeException("Can not instantiate DAO: " + clazz, ex);
        }
    }

    protected Session getCurrentSession() {
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }

}
