package com.yevhenchmykhun.controller.admin;

import com.yevhenchmykhun.repository.BookRepository;
import com.yevhenchmykhun.repository.RepositoryFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/deletebook")
public class DeleteBookController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {


        String bookId = request.getParameter("bookId");

        BookRepository bookRepository = new RepositoryFactory().getBookRepository();
        bookRepository.deleteById(Long.parseLong(bookId));

        request.setAttribute("books", bookRepository.findAll());

        String url = "/admin/view/books.jsp";
        request.getRequestDispatcher(url).forward(request, response);

    }
}
