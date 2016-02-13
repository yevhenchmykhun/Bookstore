package com.yevhenchmykhun.controller;

import com.yevhenchmykhun.cart.ShoppingCart;
import com.yevhenchmykhun.dao.DaoFactory;
import com.yevhenchmykhun.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addtocart")
public class AddToCartController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {

        String bookId = request.getParameter("id");

        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        if (cart == null) {
            cart = new ShoppingCart();
        }

        Book book = new DaoFactory().getBookDao().getEntityById(Integer.parseInt(bookId));
        cart.addItem(book);

        session.setAttribute("cart", cart);

    }
}
