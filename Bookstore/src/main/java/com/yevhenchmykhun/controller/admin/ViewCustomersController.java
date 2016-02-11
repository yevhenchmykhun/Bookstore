package com.yevhenchmykhun.controller.admin;

import com.yevhenchmykhun.dao.CustomerDao;
import com.yevhenchmykhun.dao.DaoFactory;
import com.yevhenchmykhun.entity.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewcustomers")
public class ViewCustomersController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {

        CustomerDao customerOrderDao = new DaoFactory().getCustomerDao();
        List<Customer> customers = customerOrderDao.findAll();

        request.setAttribute("customers", customers);

        String url = "/admin/view/customers.jsp";
        request.getRequestDispatcher(url).forward(request, response);

    }

}
