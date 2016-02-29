package com.yevhenchmykhun.restapi;

import com.yevhenchmykhun.dao.DaoFactory;
import com.yevhenchmykhun.entity.Book;
import com.yevhenchmykhun.entity.Category;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/")
@Consumes("application/json")
@Produces("application/json")
public class BookResource {

    @POST
    public Response postBook(Book book, @Context UriInfo uriInfo) {
        new DaoFactory().getBookDao().saveEntity(book);
        int bookId = book.getId();
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(bookId));
        return Response.created(builder.build()).build();
    }

    @GET
    public Response getBooks() {
        List<Book> books = new DaoFactory().getBookDao().findAll();
        GenericEntity<List<Book>> list = new GenericEntity<List<Book>>(books) {};
        return Response.ok(list).build();
    }

    @GET
    @Path("/{bookId}")
    public Response getBook(@PathParam("bookId") int bookId, @PathParam("categoryId") int categoryId) {
        Category category = new DaoFactory().getCategoryDao().getEntityById(categoryId);
        List<Book> books = category.getBooks();
        for (Book book : books) {
            if (book.getId() == bookId)
                return Response.ok(book).build();
        }
        return Response.noContent().build();
    }

    @PUT
    @Path("/{bookId}")
    public Response putBook(@PathParam("bookId") int bookId, Book book) {
        book.setId(bookId);
        new DaoFactory().getBookDao().updateEntity(book);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{bookId}")
    public Response deleteBook(@PathParam("bookId") int bookId) {
        new DaoFactory().getBookDao().deleteEntityById(bookId);
        return Response.noContent().build();
    }

}
