package com.jayway.alphabet.model;

import com.google.gson.annotations.SerializedName;

public class Attendee {

    @SerializedName("email")
    private String mEmail;

    @SerializedName("fullAddress")
    private String mFullAddress;

    @SerializedName("fullName")
    private String  mFullName;

    @SerializedName("phoneNumber")
    private String mPhoneNumber;

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getFullAddress() {
        return mFullAddress;
    }

    public void setFullAddress(String fullAddress) {
        mFullAddress = fullAddress;
    }

    public String getFullName() {
        return mFullName;
    }

    public void setFullName(String fullName) {
        mFullName = fullName;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

    public Attendee(String name, String phoneNumber, String email, String address) {
        this.mFullName = name;
        this.mPhoneNumber = phoneNumber;
        this.mEmail = email;
        this.mFullAddress = address;
    }
}