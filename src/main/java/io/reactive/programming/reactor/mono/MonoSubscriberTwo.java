package io.reactive.programming.reactor.mono;

import io.reactive.programming.reactor.mono.util.SubscriberUtility;
import reactor.core.publisher.Mono;

public class MonoSubscriberTwo {
    public static void main(String[] args) {
        //publisher
        Mono<Integer> orders = Mono.just("order:1")
                .map(word->word.length())
                .map(length->length/0);

        //orders.subscribe();
        orders.subscribe(
                SubscriberUtility.onNext(),
                SubscriberUtility.onError(),
                SubscriberUtility.onComplete()
        );
    }
}
