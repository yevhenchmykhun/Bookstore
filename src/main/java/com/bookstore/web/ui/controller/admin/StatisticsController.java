package com.bookstore.web.ui.controller.admin;

import com.bookstore.repository.RepositoryFactory;
import com.bookstore.model.entity.Visitor;
import com.bookstore.util.DateConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin/statistics")
public class StatisticsController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {


        List<Visitor> visitors = new RepositoryFactory().getVisitorRepository().findAll();

        DateConverter dateConverter = new DateConverter();
        List<String> dates = new ArrayList<String>();
        for (Visitor visitor : visitors) {
            String date = dateConverter.toDateInString(visitor.getDate().getTime(), "yyyy-MM-dd");
            dates.add(date);
        }

        request.setAttribute("visitors", visitors);
        request.setAttribute("dates", dates);

        String url = "/admin/view/statistics.jsp";
        request.getRequestDispatcher(url).forward(request, response);

    }
}
