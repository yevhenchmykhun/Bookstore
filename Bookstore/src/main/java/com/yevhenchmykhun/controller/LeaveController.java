package com.yevhenchmykhun.controller;

import com.yevhenchmykhun.util.DateConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/leave")
public class LeaveController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {

        DateConverter dateConverter = new DateConverter();
        String date = dateConverter.toDateInString(System.currentTimeMillis(), "yyyy-MM-dd");

        request.setAttribute("date", date);

        String url = "/WEB-INF/view/" + request.getServletPath() + ".jsp";
        request.getRequestDispatcher(url).forward(request, response);

    }
}
