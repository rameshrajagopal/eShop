package com.mycomp.eshop.models;

import java.util.List;

public class SearchRequestBuilder {
    private String searchText = "";
    private String sortBy = "";
    private List<Integer> storeIds = null;
    private Integer lastRecordedIn = null;
    private String  availability = null;

    public SearchRequestBuilder setSortBy(String sortBy) {
        this.sortBy = sortBy;
        return this;
    }

    public SearchRequestBuilder setStoreIds(List<Integer> storeIds) {
        this.storeIds = storeIds;
        return this;
    }

    public SearchRequestBuilder setLastRecordedIn(Integer lastRecordedIn) {
        this.lastRecordedIn = lastRecordedIn;
        return this;
    }

    public SearchRequestBuilder setAvailability(String availability) {
        this.availability = availability;
        return this;
    }

    public SearchRequestBuilder setSearchText(String searchText) {
        this.searchText = searchText;
        return this;
    }

    public SearchRequest build() {
        return new SearchRequest(searchText, sortBy, storeIds, lastRecordedIn, availability);
    }

    public SearchRequest getRequest(String searchText) {
        return this.setSearchText(searchText).setAvailability("IN_STOCK").setLastRecordedIn(30).build();
    }
}
