package com.yevhenchmykhun.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@WebServlet("/book-covers/*")
public class GetCoverController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {

        String filename = request.getPathInfo().substring(1);
        String absoluetPath = getServletContext().getInitParameter("absoluteCoversPath");
        File file = new File(absoluetPath, filename);
/*        response.setHeader("Content-Type", getServletContext().getMimetype(filename));*/
        response.setHeader("Content-Length", String.valueOf(file.length()));
        Files.copy(file.toPath(), response.getOutputStream());

    }

}
