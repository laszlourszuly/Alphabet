package com.jayway.alphabet.screen.order;

import com.jayway.alphabet.api.ApiClient;
import com.jayway.alphabet.api.ApiInterface;
import com.jayway.alphabet.model.Order;
import com.jayway.alphabet.model.OrderReceipt;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderRepository {
    public Observable<OrderReceipt> post(Order order) {
        return Observable.create(e -> {
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

            Call<OrderReceipt> ticketList = apiService.postOrder(order);

            ticketList.enqueue(new Callback<OrderReceipt>() {
                @Override
                public void onResponse(Call<OrderReceipt> call, Response<OrderReceipt> response) {
                    if (response.isSuccessful()) {
                        OrderReceipt changesList = response.body();
                        e.onNext(changesList);
                        e.onComplete();
                    } else {
                        e.onError(new Throwable("Something went wrong..."));
                        e.onComplete();
                    }
                }

                @Override
                public void onFailure(Call<OrderReceipt> call, Throwable t) {
                    e.onError(t);
                }
            });
        });
    }
}
