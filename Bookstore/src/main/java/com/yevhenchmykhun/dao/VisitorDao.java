package com.yevhenchmykhun.dao;

import com.yevhenchmykhun.entity.Visitor;
import org.hibernate.criterion.Restrictions;

import java.util.Date;
import java.util.List;

public class VisitorDao extends AbstractDao<Visitor, Integer> {

    public List<Visitor> getByDate(Date date) {
        return findByCriteria(Restrictions.eq("date", date));
    }

}
