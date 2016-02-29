package com.yevhenchmykhun.restapi;

import com.yevhenchmykhun.dao.DaoFactory;
import com.yevhenchmykhun.entity.Visitor;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/visitors")
@Consumes("application/json")
@Produces("application/json")
public class VisitorResource {

    @GET
    public Response getBooks() {
        List<Visitor> visitors = new DaoFactory().getVisitorDao().findAll();
        GenericEntity<List<Visitor>> list = new GenericEntity<List<Visitor>>(visitors) {};
        return Response.ok(list).build();
    }

}
