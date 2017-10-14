package com.jayway.alphabet.screen.tickets;

import com.jayway.alphabet.api.ApiClient;
import com.jayway.alphabet.api.ApiInterface;
import com.jayway.alphabet.model.Ticket;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TicketRepository {
    public Observable<List<Ticket>> get() {
        return Observable.create(e -> {
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

            Call<List<Ticket>> ticketList = apiService.getTickets();

            ticketList.enqueue(new Callback<List<Ticket>>() {
                @Override
                public void onResponse(Call<List<Ticket>> call, Response<List<Ticket>> response) {
                    if (response.isSuccessful()) {
                        List<Ticket> changesList = response.body();
                        e.onNext(changesList);
                        e.onComplete();
                    } else {
                        e.onNext(new ArrayList<>());
                        e.onComplete();
                    }
                }

                @Override
                public void onFailure(Call<List<Ticket>> call, Throwable t) {
                    e.onError(t);
                }
            });
        });
    }
}