package com.yevhenchmykhun.controller.admin;

import com.yevhenchmykhun.dao.DaoFactory;
import com.yevhenchmykhun.entity.Book;
import com.yevhenchmykhun.entity.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/editbook")
public class EditBookController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {


        String bookId = request.getParameter("bookId");

        Book book = new DaoFactory().getBookDao().getEntityById(Integer.parseInt(bookId));
        List<Category> categories = (List<Category>) getServletContext().getAttribute("categories");
        if (categories == null) {
            categories = new DaoFactory().getCategoryDao().findAll();
        }

        request.setAttribute("book", book);
        request.setAttribute("categories", categories);

        String url = "/admin/view/editbook.jsp";
        request.getRequestDispatcher(url).forward(request, response);

    }

}
