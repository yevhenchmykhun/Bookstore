package com.bookstore.web.ui.controller.admin;

import com.bookstore.repository.CategoryRepository;
import com.bookstore.repository.RepositoryFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/deletecategory")
public class DeleteCategoryController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {


        String categoryId = request.getParameter("categoryId");

        CategoryRepository categoryRepository = new RepositoryFactory().getCategoryRepository();
        categoryRepository.deleteById(Long.parseLong(categoryId));

        getServletContext().setAttribute("categories", categoryRepository.findAll());

        String url = "/admin/view/categories.jsp";
        request.getRequestDispatcher(url).forward(request, response);

    }

}
