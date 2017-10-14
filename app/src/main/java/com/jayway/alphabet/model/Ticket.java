package com.jayway.alphabet.model;

import com.google.gson.annotations.SerializedName;

public class Ticket {

    @SerializedName("id")
    private String mID;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("description")
    private String mDescription;

    @SerializedName("price")
    private String mPrice;

    public Ticket(String id, String title, String description, String price) {
        mID = id;
        mTitle = title;
        mDescription = description;
        mPrice = price;
    }

    public Ticket() {
    }

    public String getID() {
        return mID;
    }

    public void setID(String id) {
        mID = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        mPrice = price;
    }
}
