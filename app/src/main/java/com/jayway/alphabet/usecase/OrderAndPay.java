package com.jayway.alphabet.usecase;

import com.jayway.alphabet.api.PaymentRepository;
import com.jayway.alphabet.model.Order;
import com.jayway.alphabet.model.OrderReceipt;
import com.jayway.alphabet.model.Payment;
import com.jayway.alphabet.model.PaymentReceipt;
import com.jayway.alphabet.screen.order.OrderRepository;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public class OrderAndPay {
    public static Observable<PaymentReceipt> execute(Order order, Payment payment) {
        return placeOrder(order).switchMap(
                new Function<OrderReceipt, ObservableSource<PaymentReceipt>>() {
                    @Override
                    public ObservableSource<PaymentReceipt> apply(@NonNull OrderReceipt orderReceipt) throws Exception {
                        return pay(payment);
                    }
                });
    }

    private static Observable<OrderReceipt> placeOrder(final Order order) {
        return Observable.create(e -> {
            OrderRepository repo = new OrderRepository();
            repo.post(order).subscribe(new Observer<OrderReceipt>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onNext(@NonNull OrderReceipt orderReceipt) {
                    e.onNext(orderReceipt);
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
        });
    }

    private static Observable<PaymentReceipt> pay(final Payment payment) {
        return Observable.create(e -> {
            PaymentRepository repo = new PaymentRepository();
            repo.post(payment).subscribe(new Observer<PaymentReceipt>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onNext(@NonNull PaymentReceipt paymentReceipt) {
                    e.onNext(paymentReceipt);
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
        });
    }
}
