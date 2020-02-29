package com.yevhenchmykhun.controller.admin;

import com.yevhenchmykhun.repository.RepositoryFactory;
import com.yevhenchmykhun.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/viewbooks")
public class ViewBooksController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {

        List<Book> books = new RepositoryFactory().getBookRepository().findAll();

        request.setAttribute("books", books);

        String url = "/admin/view/books.jsp";
        request.getRequestDispatcher(url).forward(request, response);

    }

}
