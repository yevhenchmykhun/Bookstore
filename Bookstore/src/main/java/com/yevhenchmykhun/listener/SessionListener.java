package com.yevhenchmykhun.listener;

import com.yevhenchmykhun.dao.DaoFactory;
import com.yevhenchmykhun.dao.VisitorDao;
import com.yevhenchmykhun.entity.Visitor;
import com.yevhenchmykhun.util.DateConverter;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Date;
import java.util.List;

@WebListener()
public class SessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

        String format = "yyyy-MM-dd";

        DateConverter dateConverter = new DateConverter();
        String d = dateConverter.toDateInString(new Date().getTime(), format);

        VisitorDao visitorDao = new DaoFactory().getVisitorDao();
        List<Visitor> visitors = visitorDao.getByDate(new Date(dateConverter.toDateInMillis(d, format)));

        if (visitors.size() == 0) {
            Visitor visitor = new Visitor();
            visitor.setCount(1);
            visitor.setDate(new Date(dateConverter.toDateInMillis(d, format)));
            visitorDao.saveEntity(visitor);
        } else {
            Visitor visitor = visitors.get(0);
            visitor.setCount(visitor.getCount() + 1);
            visitorDao.updateEntity(visitor);
        }

    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
    }

}
