package com.bookstore.filter;

import com.bookstore.util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.hibernate.StaleObjectStateException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "HibernateSessionRequestFilter", urlPatterns = {"/*"})
public class HibernateSessionRequestFilter implements Filter {

    private SessionFactory sessionFactory;

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        try {
            sessionFactory.getCurrentSession().beginTransaction();
            chain.doFilter(request, response);
            sessionFactory.getCurrentSession().getTransaction().commit();
        } catch (StaleObjectStateException e) {
            // Compensation actions
            throw e;
        } catch (Throwable e) {
            // Rollback only
            e.printStackTrace();
            try {
                if (sessionFactory.getCurrentSession().getTransaction() != null) {
                    System.out
                            .println("Trying to rollback database transaction after exception.");
                    sessionFactory.getCurrentSession().getTransaction()
                            .rollback();
                }
            } catch (Throwable ex) {
                System.out
                        .println("Could not rollback transaction after exception!");
            }
        }

    }

    public void init(FilterConfig fConfig) throws ServletException {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void destroy() {
    }

}
