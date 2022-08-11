package io.reactive.programming.reactor.flux;

import io.reactive.programming.reactor.flux.utility.FluxSubscriber;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class FluxSubscription {
    public static void main(String[] args) {
        AtomicReference<Subscription> subscriptionAtomicReference=new AtomicReference<>();
        Flux.range(1,20)
                .log()
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        System.out.println("Starting>> "+s);
                        subscriptionAtomicReference.set(s);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("On Next>> "+integer*2);
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.out.println("On Error>> "+t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Successfully Completed!!");
                    }
                });
        FluxSubscriber.sleep(3);
        subscriptionAtomicReference.get().request(4);
        FluxSubscriber.sleep(5);
        subscriptionAtomicReference.get().request(4);
        subscriptionAtomicReference.get().cancel();
        FluxSubscriber.sleep(2);
        subscriptionAtomicReference.get().request(4);
    }

}
