package com.yevhenchmykhun.controller.admin;

import com.yevhenchmykhun.dao.CustomerOrderDao;
import com.yevhenchmykhun.dao.DaoFactory;
import com.yevhenchmykhun.entity.CustomerOrder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/vieworders")
public class ViewOrdersController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {

        CustomerOrderDao customerOrderDao = new DaoFactory().getCustomerOrderDao();
        List<CustomerOrder> orders = customerOrderDao.findAll();

        request.setAttribute("orders", orders);

        String url = "/admin/view/orders.jsp";
        request.getRequestDispatcher(url).forward(request, response);

    }

}
