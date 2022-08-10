package io.reactive.programming.reactor.flux;

import io.reactive.programming.reactor.flux.utility.FluxSubscriber;
import reactor.core.publisher.Flux;

public class FluxIntro {
    public static void main(String[] args) {
        Flux<Integer> flux=Flux.just(1);

        flux.subscribe(FluxSubscriber.onNext());
    }
}
