package com.yevhenchmykhun.controller;

import com.yevhenchmykhun.dao.BookDao;
import com.yevhenchmykhun.dao.DaoFactory;
import com.yevhenchmykhun.entity.Book;
import com.yevhenchmykhun.util.DateConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/description")
public class DescriptionController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {

        String bookId = request.getParameter("id");

        BookDao bookDao = new DaoFactory().getBookDao();
        Book book = bookDao.getEntityById(Integer.parseInt(bookId));

        request.setAttribute("book", book);
        request.setAttribute("releaseDate", new DateConverter().toDateInString(book.getReleaseDate().getTime(), "yyyy-MM-dd"));

        String url = "/WEB-INF/view/description.jsp";
        request.getRequestDispatcher(url).forward(request, response);

    }

}
