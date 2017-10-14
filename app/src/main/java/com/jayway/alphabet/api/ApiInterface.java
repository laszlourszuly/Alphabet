package com.jayway.alphabet.api;


import com.jayway.alphabet.model.Order;
import com.jayway.alphabet.model.OrderReceipt;
import com.jayway.alphabet.model.Ticket;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET("tickets")
    Call<List<Ticket>> getTickets();

    @POST("order")
    Call<OrderReceipt> postOrder(Order order);
}