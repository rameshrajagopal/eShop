package com.mycomp.eshop.controller;


import com.mycomp.eshop.clients.HttpClient;
import com.mycomp.eshop.models.ApiRequest;

public class ShoppingController {
    private ApiRequest request = null;
    private HttpClient client  = null;

    public ShoppingController() {
        this.request = new ApiRequest("http", "scarlet.prod.platform.io", "/search", "indix.com", "abcd");
        this.client  = new HttpClient();
    }
}
