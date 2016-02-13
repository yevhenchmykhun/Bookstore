package com.yevhenchmykhun.controller;

import com.yevhenchmykhun.cart.ShoppingCart;
import com.yevhenchmykhun.controller.validate.Validator;
import com.yevhenchmykhun.manager.OrderManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/purchase")
public class PurchaseController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String ccNumber = request.getParameter("credit-card");

        String check = new Validator().validatePurchase(name, email, phone, address, city, ccNumber);

        String url;
        if (check == null) {
            HttpSession session = request.getSession();
            ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

            OrderManager manager = new OrderManager();
            manager.placeOrder(name, email, phone, address, city, ccNumber, cart);

            request.setAttribute("email", email);
            request.setAttribute("phone", phone);
            request.setAttribute("address", address);
            request.setAttribute("city", city);

            url = "/leave";
        } else {
            url = "/WEB-INF/view/error/massagepage.jsp";
            request.setAttribute("message", check);
        }

        request.getRequestDispatcher(url).forward(request, response);

    }
}
