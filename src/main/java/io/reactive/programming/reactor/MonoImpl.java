package io.reactive.programming.reactor;

import reactor.core.publisher.Mono;

public class MonoImpl {
    public static void main(String[] args) {
        //publisher
        Mono<Integer> integerMono = Mono.just(1);
        integerMono.subscribe(i-> System.out.println("Received "+i));
        //System.out.println(integerMono);
    }
}
