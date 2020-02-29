package com.yevhenchmykhun.listener;

import com.yevhenchmykhun.repository.RepositoryFactory;
import com.yevhenchmykhun.repository.VisitorRepository;
import com.yevhenchmykhun.entity.Visitor;
import com.yevhenchmykhun.util.DateConverter;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebListener()
public class SessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

        String format = "yyyy-MM-dd";

        DateConverter dateConverter = new DateConverter();
        String d = dateConverter.toDateInString(new Date().getTime(), format);

        VisitorRepository visitorRepository = new RepositoryFactory().getVisitorRepository();

        try {
            List<Visitor> visitors = visitorRepository.findByDate(new Date(dateConverter.toDateInMillis(d, format)));

            if (visitors.size() == 0) {
                Visitor visitor = new Visitor();
                visitor.setCount(1);
                visitor.setDate(new Date(dateConverter.toDateInMillis(d, format)));
                visitorRepository.saveAndFlush(visitor);
            } else {
                Visitor visitor = visitors.get(0);
                visitor.setCount(visitor.getCount() + 1);
                visitorRepository.saveAndFlush(visitor);
            }
        } catch (IOException e) {
            //NOOP
        }

    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
    }

}
