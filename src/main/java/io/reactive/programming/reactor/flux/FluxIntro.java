package io.reactive.programming.reactor.flux;

import io.reactive.programming.reactor.flux.subscriber.FluxSubscriber;
import reactor.core.publisher.Flux;

public class FluxIntro {
    public static void main(String[] args) {
        Flux<Integer> intFlux=Flux.just(1,2,3,4,5,36);
        Flux<Object> objFlux=Flux.just(true,6,2.8,"a", new int[]{1, 2, 3});
        objFlux.subscribe(
                FluxSubscriber.onNext(),
                FluxSubscriber.onError(),
                FluxSubscriber.onComplete()
        );
    }
}
