package com.mycomp.eshop.models;

import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.util.List;


public class ApiRequest {
    private static Logger Log = LoggerFactory.getLogger(ApiRequest.class);
    private String scheme;
    private String host;
    private String endpoint;
    private String appId;
    private String appKey;

    public ApiRequest(String scheme, String host, String endpoint, String appId, String appKey) {
        this.scheme = scheme;
        this.host = host;
        this.endpoint = endpoint;
        this.appId = appId;
        this.appKey = appKey;
    }

    public URI getUri(SearchRequest request) {
        URIBuilder builder = new URIBuilder();
        //mandatory parameters
        builder.setScheme(scheme).setHost(host).setPath(endpoint)
                .setParameter("app_id", appId).setParameter("app_key", appKey)
                .setParameter("q", request.getSearchText());
        // optional parameters
        Integer lastRecordedIn = request.getLastRecordedIn();
        if (lastRecordedIn != null) {
            builder.setParameter("lastRecordedIn", lastRecordedIn.toString());
        }
        String availability = request.getAvailability();
        if (availability != null) {
            builder.setParameter("availability", availability);
        }
        // addStoreIds if any
        List<Integer> storeIds = request.getStoreIds();
        if (storeIds != null) {
            for (Integer storeId : storeIds) {
                builder.addParameter("storeId", storeId.toString());
            }
        }
        //getUri and return
        URI uri = null;
        try {
            uri = builder.build();
            Log.info("op=getRequest, uri=" + uri.toString());
        } catch (Exception e) {
            Log.error(e.getMessage());
        }
        return uri;
    }
}
