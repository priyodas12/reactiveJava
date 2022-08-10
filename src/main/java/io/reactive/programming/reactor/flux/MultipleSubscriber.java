package io.reactive.programming.reactor.flux;

import reactor.core.publisher.Flux;

public class MultipleSubscriber {
    public static void main(String[] args) {
        Flux<Integer> intFlux = Flux.just(1, 2, 3, 4, 5, 36);
        intFlux.subscribe(i-> System.out.println("sub>1:: "+i));
        intFlux.subscribe(i-> System.out.println("sub>2:: "+i));
    }
}
