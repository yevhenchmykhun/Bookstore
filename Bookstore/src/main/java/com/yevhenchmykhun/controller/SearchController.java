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

@WebServlet("/searchresult")
public class SearchController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {

        String search = request.getParameter("search");

        BookDao bookDao = new DaoFactory().getBookDao();

        List<Book> books = bookDao.findByTitle(search);
        if (books.size() == 0) {
            books = bookDao.findByAuthor(search);
            if (books.size() == 0)
                books = bookDao.findByIsbn(search);
        }

        String url;
        if (books.size() != 0) {
            url = "/WEB-INF/view/searchresult.jsp";
            request.setAttribute("books", books);
        } else {
            url = "/WEB-INF/view/error/massagepage.jsp";
            request.setAttribute("message", "No result for such request");
        }

        request.getRequestDispatcher(url).forward(request, response);

    }

}
