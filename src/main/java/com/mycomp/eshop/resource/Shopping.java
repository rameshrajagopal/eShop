package com.mycomp.eshop.resource;

import com.mycomp.eshop.controller.ShoppingController;
import com.mycomp.eshop.models.SearchRequest;
import com.mycomp.eshop.models.SearchRequestBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/search")
@Produces(MediaType.APPLICATION_JSON)
public class Shopping {
    private static final Logger LOG = LoggerFactory.getLogger(Shopping.class);
    private ShoppingController shoppingController = null;

    public Shopping() {
        shoppingController = new ShoppingController();
    }

    @GET
    public Response getProducts(@QueryParam("q") String searchTerm, @QueryParam("sortBy") String sortBy) {
        LOG.info("op=getProducts, q=" + searchTerm + ",sortBy=" + sortBy);
        // buildRequest
        SearchRequest searchRequest = new SearchRequestBuilder().getRequest(searchTerm);
        try {
            String response = shoppingController.getProducts(searchRequest);
            return Response.ok(response).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
