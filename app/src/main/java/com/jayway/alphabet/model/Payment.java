package com.jayway.alphabet.model;

import com.google.gson.annotations.SerializedName;

public class Payment {

    @SerializedName("amound")
    private int mAmount;

    @SerializedName("id")
    private String mId;

    @SerializedName("method")
    private String mMethod;

    @SerializedName("orderId")
    private String mOrderId;

    @SerializedName("poNumber")
    private String mPoNumber;

    @SerializedName("status")
    private String mStatus;

    @SerializedName("tenant")
    private String mTenant;

    public int getAmount() {
        return mAmount;
    }

    public void setAmount(int amount) {
        mAmount = amount;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getMethod() {
        return mMethod;
    }

    public void setMethod(String method) {
        mMethod = method;
    }

    public String getOrderId() {
        return mOrderId;
    }

    public void setOrderId(String orderId) {
        mOrderId = orderId;
    }

    public String getPoNumber() {
        return mPoNumber;
    }

    public void setPoNumber(String poNumber) {
        mPoNumber = poNumber;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public String getTenant() {
        return mTenant;
    }

    public void setTenant(String tenant) {
        mTenant = tenant;
    }
}
