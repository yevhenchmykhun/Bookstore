package com.yevhenchmykhun.dao;

import com.yevhenchmykhun.entity.Book;
import com.yevhenchmykhun.entity.Category;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class BookDao extends AbstractDao<Book, Integer> {

    public List<Book> findByTitle(String title) {
        return findByCriteria(Restrictions.like("name", "%" + title + "%"));
    }

    public List<Book> findByAuthor(String author) {
        return findByCriteria(Restrictions.like("author", "%" + author + "%"));
    }

    public List<Book> findByIsbn(String isbn) {
        return findByCriteria(Restrictions.like("isbn", "%" + isbn + "%"));
    }

    @SuppressWarnings("unchecked")
    public List<Book> getPage(int categoryId, int pageNumber, int pageSize) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        Category category = new Category();
        category.setId(categoryId);
        criteria.add(Restrictions.eq("category", category));
        criteria.setFirstResult((pageNumber - 1) * pageSize);
        criteria.setMaxResults(pageSize);

        return (List<Book>) criteria.list();
    }

    public int getNumberOfRows(int categoryId) {
        String sqlQuery = "select count(*) from " + getPersistentClass().getSimpleName() + " where category_id = " + categoryId;
        return ((Long) getSession().createQuery(sqlQuery).iterate().next()).intValue();
    }

}
