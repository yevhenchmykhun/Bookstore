package com.yevhenchmykhun.controller;

import com.yevhenchmykhun.cart.ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/cart")
public class CartController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

        String url;
        if (cart != null && cart.getNumberOfItems() != 0) {
            url = "/WEB-INF/view/cart.jsp";
        } else {
            url = "/WEB-INF/view/error/massagepage.jsp";
            request.setAttribute("message", "Shopping Cart is empty");
        }

        request.getRequestDispatcher(url).forward(request, response);

    }
}
