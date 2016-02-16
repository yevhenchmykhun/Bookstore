package com.yevhenchmykhun.controller.admin;

import com.yevhenchmykhun.dao.BookDao;
import com.yevhenchmykhun.dao.DaoFactory;
import com.yevhenchmykhun.entity.Book;
import com.yevhenchmykhun.util.DateConverter;
import com.yevhenchmykhun.util.ImageUploader;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;

@WebServlet("/admin/addbook")
@MultipartConfig
public class AddNewBookController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String language = request.getParameter("language");
        String publisher = request.getParameter("publisher");
        String format = request.getParameter("format");
        String isbn = request.getParameter("isbn");
        String pages = request.getParameter("pages");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String categoryId = request.getParameter("selection");
        String releasedate = request.getParameter("releasedate");
        String description = request.getParameter("description");

        Book book = new Book();

        book.setName(title);
        book.setAuthor(author);
        book.setLanguage(language);
        book.setPublisher(publisher);
        book.setFormat(format);
        book.setIsbn(isbn);
        book.setPages(Integer.parseInt(pages));
        book.setPrice(new BigDecimal(Double.parseDouble(price)));
        book.setQuantity(Integer.parseInt(quantity));
        book.setCategory(new DaoFactory().getCategoryDao().getEntityById(Integer.parseInt(categoryId)));
        book.setReleaseDate(new Timestamp(new DateConverter().toDateInMillis(releasedate + "-01", "yyyy-MM-dd")));
        book.setDescription(description);

        Part part = request.getPart("file"); // Retrieves <input type="file" name="file">
        String coversPath = getServletContext().getInitParameter("absoluteCoversPath");
        String cover = new ImageUploader().upload(part, title, coversPath);
        book.setCover(cover);

        BookDao bookDao = new DaoFactory().getBookDao();
        bookDao.saveEntity(book);

        String url = "/admin/viewbooks";
        request.getRequestDispatcher(url).forward(request, response);

    }

}
