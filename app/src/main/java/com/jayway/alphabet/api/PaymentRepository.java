package com.jayway.alphabet.api;

import com.jayway.alphabet.model.Payment;
import com.jayway.alphabet.model.PaymentReceipt;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaymentRepository {
    public Observable<PaymentReceipt> post(Payment order) {
        return Observable.create(e -> {
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

            Call<PaymentReceipt> ticketList = apiService.postPayment(order);

            ticketList.enqueue(new Callback<PaymentReceipt>() {
                @Override
                public void onResponse(Call<PaymentReceipt> call, Response<PaymentReceipt> response) {
                    if (response.isSuccessful()) {
                        PaymentReceipt changesList = response.body();
                        e.onNext(changesList);
                        e.onComplete();
                    } else {
                        e.onError(new Throwable("Something went wrong..."));
                        e.onComplete();
                    }
                }

                @Override
                public void onFailure(Call<PaymentReceipt> call, Throwable t) {
                    e.onError(t);
                }
            });
        });
    }
}
