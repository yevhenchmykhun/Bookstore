package com.bookstore.controller.admin;

import com.bookstore.repository.RepositoryFactory;
import com.bookstore.entity.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/viewcategories")
public class ViewCategoriesController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {

        List<Category> categories = (List<Category>) getServletContext().getAttribute("categories");
        if (categories == null) {
            categories = new RepositoryFactory().getCategoryRepository().findAll();
        }

        request.setAttribute("categories", categories);

        String url = "/admin/view/categories.jsp";
        request.getRequestDispatcher(url).forward(request, response);

    }
}
