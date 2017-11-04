package com.mycomp.eshop.clients;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;

public class HttpClient {
    private static int HTTP_SUCCESS = 200;
    private static int HTTP_NOT_FOUND = 404;

    private CloseableHttpClient httpClient = null;

    public HttpClient() {
        httpClient = HttpClients.createDefault();
    }

    public CloseableHttpResponse get(URI uri) {
        HttpGet request = new HttpGet(uri);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(request);
        } catch(IOException | UnsupportedOperationException e) {
            e.printStackTrace();
        }
        return response;
    }
}
