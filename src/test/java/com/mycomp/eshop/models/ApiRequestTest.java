package com.mycomp.eshop.models;

import com.mycomp.eshop.AppTest;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.List;


public class ApiRequestTest extends TestCase {

    public ApiRequestTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( ApiRequestTest.class );
    }

    public void testGetRequest() {
        ApiRequest apiRequest = new ApiRequest("http", "scarlet.prod.platform.io", "/search", "indix.com", "abcd");
        List<Integer> storeIds = null;
        assertEquals("http://scarlet.prod.platform.io/search?app_id=indix.com&app_key=abcd&q=black",
                apiRequest.getRequest("black", storeIds).toString());
    }

    public void testGetRequestWithStoreIds() {
        ApiRequest apiRequest = new ApiRequest("http", "scarlet.prod.platform.io", "/search", "indix.com", "abcd");
        List<Integer> storeIds = new ArrayList<Integer>(3);
        for (int idx = 0; idx < 3; ++idx) {
            storeIds.add(idx);
        }
        assertEquals("http://scarlet.prod.platform.io/search?app_id=indix.com&app_key=abcd&q=black&storeId=0&storeId=1&storeId=2",
                apiRequest.getRequest("black", storeIds).toString());
    }
}
