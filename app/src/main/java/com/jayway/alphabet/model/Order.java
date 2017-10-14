package com.jayway.alphabet.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Order {
    @SerializedName("attendees")
    private ArrayList<Attendee> attendees;

    @SerializedName("company")
    private String company;

    @SerializedName("id")
    private String id;

    @SerializedName("orderStatus")
    private String orderStatus;

    @SerializedName("poNumber")
    private String poNumber;

    @SerializedName("price")
    private String price;

    @SerializedName("tenant")
    private String tenant;

    @SerializedName("weekdays")
    private ArrayList<String> weekdays;

    public ArrayList<Attendee> getAttendees() {
        return attendees;
    }

    public void setAttendees(ArrayList<Attendee> attendees) {
        this.attendees = attendees;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public ArrayList<String> getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(ArrayList<String> weekdays) {
        this.weekdays = weekdays;
    }

    public Order(ArrayList<Attendee> attendees) {
        this.attendees = attendees;
    }
}

