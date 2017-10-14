package com.jayway.alphabet.api;


import com.jayway.alphabet.model.Ticket;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("tickets")
    Call<List<Ticket>> getTickets();
}