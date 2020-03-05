package com.bookstore.controller.admin;

import com.bookstore.repository.RepositoryFactory;
import com.bookstore.entity.Book;
import com.bookstore.entity.Category;
import com.bookstore.util.DateConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/editbook")
public class EditBookController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String bookId = request.getParameter("bookId");

        Book book = new RepositoryFactory().getBookRepository().getOne(Long.parseLong(bookId));
        List<Category> categories = (List<Category>) getServletContext().getAttribute("categories");
        if (categories == null) {
            categories = new RepositoryFactory().getCategoryRepository().findAll();
        }

        request.setAttribute("book", book);
        request.setAttribute("categories", categories);
        request.setAttribute("date", new DateConverter().toDateInString(book.getReleaseDate().getTime(), "yyyy-MM"));

        String url = "/admin/view/editbook.jsp";
        request.getRequestDispatcher(url).forward(request, response);

    }

}
