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

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

        String url = null;
        if (cart != null) {
            url = "/WEB-INF/view/" + request.getServletPath() + ".jsp";
        } else {
            url = "/WEB-INF/view/error/errorpage.jsp";
            request.setAttribute("message", "Shopping Cart is empty, bitch");
        }

        request.getRequestDispatcher(url).forward(request, response);

    }
}
