package com.mycomp.eshop.clients;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

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

    public String get(URI uri) {
        HttpGet request = new HttpGet(uri);
        String responseBody = null;

        // Create a custom response handler
        ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
            @Override
            public String handleResponse(
                    final HttpResponse response) throws ClientProtocolException, IOException {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            }
        };
        try {
            responseBody = httpClient.execute(request, responseHandler);
        } catch(IOException | UnsupportedOperationException e) {
            e.printStackTrace();
        }
        return responseBody;
    }
}
