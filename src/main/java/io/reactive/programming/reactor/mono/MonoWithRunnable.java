package io.reactive.programming.reactor.mono;

import io.reactive.programming.reactor.mono.util.SubscriberUtility;
import reactor.core.publisher.Mono;

public class MonoWithRunnable {
    public static void main(String[] args) {

        Runnable runnable = () -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            System.out.println("Process took time but Nothing to return");
        };

        Mono.fromRunnable(runnable)
                .subscribe(
                     SubscriberUtility.onNext()
                    ,SubscriberUtility.onError()
                    ,SubscriberUtility.onComplete()
                );
    }
}
