package com.mycomp.eshop.clients;


import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.eclipse.jetty.http.HttpStatus;

import java.io.IOException;
import java.net.URI;

public class HttpClient {
    private CloseableHttpClient httpClient = null;

    public HttpClient() {
        httpClient = HttpClients.createDefault();
    }

    public String get(URI uri) {
        HttpGet request = new HttpGet(uri);
        String responseBody = null;

        // Create a custom response handler
        ResponseHandler<String> responseHandler = response -> {
            int status = response.getStatusLine().getStatusCode();
            if (status >= HttpStatus.OK_200 && status < HttpStatus.MULTIPLE_CHOICES_300) {
                HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : null;
            } else {
                throw new ClientProtocolException("Unexpected response status: " + status);
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
