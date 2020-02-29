package com.yevhenchmykhun.controller;

import com.yevhenchmykhun.cart.ShoppingCart;
import com.yevhenchmykhun.repository.RepositoryFactory;
import com.yevhenchmykhun.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/updatequantity")
public class UpdateQuantityController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {

        String bookId = request.getParameter("bookId");
        String quantity = request.getParameter("quantity");

        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

        Book book = new RepositoryFactory().getBookRepository().getOne(Long.parseLong(bookId));

        int parsedQuantity = Integer.parseInt(quantity);

        String url;
        if (parsedQuantity < 0) {
            url = "/WEB-INF/view/error/massagepage.jsp";
            request.setAttribute("message", "Quantity must not be less then 0");
        } else if (book.getQuantity() < parsedQuantity) {
            url = "/WEB-INF/view/error/massagepage.jsp";
            request.setAttribute("message", "Not enough books in store for update");
        } else {
            cart.update(book, parsedQuantity);
            url = "/cart";
        }

        request.getRequestDispatcher(url).forward(request, response);

    }

}
