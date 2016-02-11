package com.yevhenchmykhun.controller;

import com.yevhenchmykhun.dao.BookDao;
import com.yevhenchmykhun.dao.DaoFactory;
import com.yevhenchmykhun.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/index")
public class IndexController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().setAttribute("categories", new DaoFactory().getCategoryDao().findAll());

        BookDao bookDao = new DaoFactory().getBookDao();
        List<Book> pageOne = bookDao.getPage(2, 1, 6);
        List<Book> pageTwo = bookDao.getPage(2, 2, 6);

        request.setAttribute("paeOne", pageOne);
        request.setAttribute("pageTwo", pageTwo);

        request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);

    }

}
