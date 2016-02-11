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

@WebServlet("/category")
public class CategoryController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {

        int page = 1;
        int booksPerPage = 5;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        int categoryId = Integer.parseInt(request.getParameter("id"));

        BookDao bookDao = new DaoFactory().getBookDao();
        List<Book> books = bookDao.getPage(categoryId, page, booksPerPage);

        String url = null;
        if (books.size() != 0) {
            int numberOfRows = bookDao.getNumberOfRows();
            int numberOfPages = (int) Math.ceil(numberOfRows * 1.0 / booksPerPage);

            request.setAttribute("books", books);
            request.setAttribute("currentPage", page);
            request.setAttribute("categoryId", categoryId);
            request.setAttribute("numberOfPages", numberOfPages);

            url = "/WEB-INF/view/" + request.getServletPath() + ".jsp";
        } else {
            url = "/WEB-INF/view/error/errorpage.jsp";
            request.setAttribute("message", "Category is empty, bitch");
        }

        request.getRequestDispatcher(url).forward(request, response);

    }
}
