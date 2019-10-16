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

@WebServlet("/index")
public class IndexController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().setAttribute("categories", new RepositoryFactory().getCategoryRepository().findAll());

        BookRepository bookRepository = new RepositoryFactory().getBookRepository();
//        List<Book> pageOne = bookDao.getPage(2, 1, 6);
//        List<Book> pageTwo = bookDao.getPage(2, 2, 6);

        List<Book> pageOne = bookRepository.findAllByCategoryId(2L, PageRequest.of(0, 6));
        List<Book> pageTwo = bookRepository.findAllByCategoryId(2L, PageRequest.of(1, 6));

        request.setAttribute("pageOne", pageOne);
        request.setAttribute("pageTwo", pageTwo);

        String url = "/WEB-INF/view/index.jsp";
        request.getRequestDispatcher(url).forward(request, response);

    }

}
