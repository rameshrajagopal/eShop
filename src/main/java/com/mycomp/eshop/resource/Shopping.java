package com.mycomp.eshop.resource;

import com.mycomp.eshop.clients.HttpClient;
import com.mycomp.eshop.models.ApiRequest;
import jdk.net.SocketFlow;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/search")
@Produces(MediaType.APPLICATION_JSON)
public class Shopping {
    private static final Logger LOG = LoggerFactory.getLogger(Shopping.class);
    private ApiRequest request = null;

    public Shopping() {
        request = new ApiRequest("http", "scarlet.prod.platform.io", "/search", "indix.com", "abcd");
    }

    @GET
    public Response getProducts(@QueryParam("q") String searchTerm, @QueryParam("sortBy") String sortBy) {
        LOG.info("op=getProducts, q=" + searchTerm + ",sortBy=" + sortBy);
        HttpClient httpClient = new HttpClient();
        List<Integer> storeIds = null;
        URI uri = request.getRequest(searchTerm, storeIds);
        CloseableHttpResponse response = httpClient.get(uri);
        try {
            System.out.println(response.getEntity().getContent().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
