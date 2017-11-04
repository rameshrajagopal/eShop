package com.mycomp.eshop.resource;

import jdk.net.SocketFlow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/search")
@Produces(MediaType.APPLICATION_JSON)
public class Shopping {
    private static final Logger LOG = LoggerFactory.getLogger(Shopping.class);

    public Response getProducts(@PathParam("q") String searchTerm, @PathParam("sortBy") String sortBy) {
        LOG.info("op=getProducts, q=" + searchTerm + ",sortBy=" + sortBy);
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
