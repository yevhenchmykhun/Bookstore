package com.yevhenchmykhun.controller.admin;

import com.yevhenchmykhun.dao.CategoryDao;
import com.yevhenchmykhun.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletecategory")
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

        CategoryDao categoryDao =  new DaoFactory().getCategoryDao();
        categoryDao.deleteEntityById(Integer.parseInt(categoryId));

        getServletContext().setAttribute("categories", categoryDao.findAll());

        String url = "/admin/view/categories.jsp";
        request.getRequestDispatcher(url).forward(request, response);

    }

}
