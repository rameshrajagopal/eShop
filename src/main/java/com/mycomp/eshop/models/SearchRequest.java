package com.mycomp.eshop.models;

import java.util.List;


public class SearchRequest {
    private String searchText;
    private String sortBy;
    private List<Integer> storeIds;
    private Integer lastRecordedIn;
    private String  availability;

    public SearchRequest(String searchText, String sortBy, List<Integer> storeIds, Integer lastRecordedIn,
                         String availability) {
        this.searchText = searchText;
        this.sortBy = sortBy;
        this.storeIds = storeIds;
        this.lastRecordedIn = lastRecordedIn;
        this.availability = availability;
    }

    public String getSearchText() {
        return searchText;
    }

    public String getSortBy() {
        return sortBy;
    }

    public List<Integer> getStoreIds() {
        return storeIds;
    }

    public Integer getLastRecordedIn() {
        return lastRecordedIn;
    }

    public String getAvailability() {
        return availability;
    }
}


