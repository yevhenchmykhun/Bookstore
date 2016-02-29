package com.yevhenchmykhun.restapi;

import com.yevhenchmykhun.dao.DaoFactory;
import com.yevhenchmykhun.entity.Category;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/categories")
@Consumes("application/json")
@Produces("application/json")
public class CategoryResource {

    @POST
    public Response postCategory(Category category, @Context UriInfo uriInfo) {
        new DaoFactory().getCategoryDao().saveEntity(category);
        int categoryId = category.getId();
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(categoryId));
        return Response.created(builder.build()).build();
    }

    @GET
    public Response getCategories() {
        List<Category> categories = new DaoFactory().getCategoryDao().findAll();
        GenericEntity<List<Category>> list = new GenericEntity<List<Category>>(categories) {};
        return Response.ok(list).build();
    }

    @GET
    @Path("/{categoryId}")
    public Response getCategory(@PathParam("categoryId") int categoryId) {
        Category category = new DaoFactory().getCategoryDao().getEntityById(categoryId);
        if (category == null)
            return Response.noContent().build();
        else
            return Response.ok(category).build();
    }

    @PUT
    @Path("/{categoryId}")
    public Response putCategory(@PathParam("categoryId") int categoryId, Category category) {
        category.setId(categoryId);
        new DaoFactory().getCategoryDao().updateEntity(category);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{categoryId}")
    public Response deleteCategory(@PathParam("categoryId") int categoryId) {
        new DaoFactory().getCategoryDao().deleteEntityById(categoryId);
        return Response.noContent().build();
    }

    @Path("/{categoryId}/books")
    public BookResource getBookResource() {
        return new BookResource();
    }

}
