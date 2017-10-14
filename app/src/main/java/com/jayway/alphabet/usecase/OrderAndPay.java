package com.jayway.alphabet.usecase;

import com.jayway.alphabet.model.Order;
import com.jayway.alphabet.model.OrderReceipt;
import com.jayway.alphabet.model.Ticket;
import com.jayway.alphabet.screen.order.OrderRepository;
import com.jayway.alphabet.screen.tickets.TicketRepository;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class OrderAndPay {
    public static Observable<Boolean> execute(Order order) {
        return Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Boolean> e) throws Exception {
                OrderRepository repo = new OrderRepository();
                repo.post(order).subscribe(new Observer<OrderReceipt>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull OrderReceipt orderReceipt) {
                        e.onNext(true);
                        e.onComplete();
                    }

                    @Override
                    public void onError(@NonNull Throwable throwable) {
                        e.onError(throwable);
                    }

                    @Override
                    public void onComplete() {
                        e.onComplete();
                    }
                });
            }
        });
    }
}
