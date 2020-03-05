package com.bookstore.controller.admin;

import com.bookstore.repository.CustomerOrderRepository;
import com.bookstore.repository.RepositoryFactory;
import com.bookstore.entity.CustomerOrder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/admin/vieworders")
public class ViewOrdersController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {

        CustomerOrderRepository customerOrderRepository = new RepositoryFactory().getCustomerOrderRepository();
        List<CustomerOrder> orders = customerOrderRepository.findAll();

        request.setAttribute("orders", orders);

        String url = "/admin/view/orders.jsp";
        request.getRequestDispatcher(url).forward(request, response);

    }

}
