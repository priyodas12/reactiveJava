package io.reactive.programming.reactor.flux;

import io.reactive.programming.reactor.flux.utility.FluxSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxFromMono {
    public static void main(String[] args) {
        Mono<Integer> testMono=Mono.just(100);

        Flux<Integer> fromMono= Flux.from(testMono);

        fromMono.subscribe(FluxSubscriber.onNext());


    }
}
