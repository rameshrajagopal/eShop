package com.mycomp.eshop.controller;


import com.mycomp.eshop.clients.HttpClient;
import com.mycomp.eshop.models.ApiRequest;
import com.mycomp.eshop.models.SearchRequest;
import com.mycomp.eshop.resource.Shopping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

public class ShoppingController {
    private static final Logger Log = LoggerFactory.getLogger(Shopping.class);
    private ApiRequest apiRequest = null;
    private HttpClient client  = null;

    public ShoppingController() {
        this.apiRequest = new ApiRequest("http", "scarlet.prod.platform.io", "/search", "indix.com", "abcd");
        this.client  = new HttpClient();
    }

    public String getProducts(SearchRequest searchReq) {
        Log.info("op=getProducts, req=" + searchReq);
        URI uri = apiRequest.getUri(searchReq);
        try {
            return client.get(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // emptyString
        return null;
    }
}
