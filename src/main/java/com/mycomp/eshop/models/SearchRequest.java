package com.mycomp.eshop.models;

import java.util.List;

/**
 * Created by indix on 04/11/17.
 */
public class SearchRequest {
    private String searchText;
    private String sortBy;
    private List<Integer> storeIds;
    private Integer lastRecordedIn;
    private String  availability;

}
