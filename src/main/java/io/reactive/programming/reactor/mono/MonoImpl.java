package io.reactive.programming.reactor.mono;

import reactor.core.publisher.Mono;

public class MonoImpl {
    public static void main(String[] args) {

        //publisher(interface)
        Mono<Integer> integerMono = Mono.just(1);
        //nothing happen until subscribe
        integerMono.subscribe(i-> System.out.println("Received "+i));
        //System.out.println(integerMono);
    }
}
