package com.yevhenchmykhun.controller;

import com.yevhenchmykhun.repository.BookRepository;
import com.yevhenchmykhun.repository.RepositoryFactory;
import com.yevhenchmykhun.entity.Book;
import org.springframework.data.domain.PageRequest;

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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {

        int page = 0;
        int booksPerPage = 5;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        int categoryId = Integer.parseInt(request.getParameter("id"));

        BookRepository bookRepository = new RepositoryFactory().getBookRepository();
//        List<Book> books = bookDao.getPage(categoryId, page, booksPerPage);
        List<Book> books = bookRepository.findAllByCategoryId((long) categoryId, PageRequest.of(page, booksPerPage));

        String url;
        if (books.size() != 0) {
//            int numberOfRows = bookDao.getNumberOfRows(categoryId);
            int numberOfRows = bookRepository.countByCategoryId((long) categoryId);
            int numberOfPages = (int) Math.ceil(numberOfRows * 1.0 / booksPerPage);

            request.setAttribute("books", books);
            request.setAttribute("currentPage", page + 1);
            request.setAttribute("categoryId", categoryId);
            request.setAttribute("numberOfPages", numberOfPages);

            url = "/WEB-INF/view/category.jsp";
        } else {
            url = "/WEB-INF/view/error/massagepage.jsp";
            request.setAttribute("message", "Category is empty");
        }

        request.getRequestDispatcher(url).forward(request, response);

    }
}
