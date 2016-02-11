package com.yevhenchmykhun.controller;

import com.yevhenchmykhun.dao.BookDao;
import com.yevhenchmykhun.dao.DaoFactory;
import com.yevhenchmykhun.entity.Book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/description")
public class DescriptionController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {

        String bookId = request.getParameter("id");

        if (request.getAttribute("bookIdFromAddToCart") != null) {
            bookId = (String) request.getAttribute("bookIdFromAddToCart");
        }

        BookDao bookDao = new DaoFactory().getBookDao();
        Book book = bookDao.getEntityById(Integer.parseInt(bookId));

        request.setAttribute("book", book);

        String url = "/WEB-INF/view/" + request.getServletPath() + ".jsp";

        request.getRequestDispatcher(url).forward(request, response);

    }

}
