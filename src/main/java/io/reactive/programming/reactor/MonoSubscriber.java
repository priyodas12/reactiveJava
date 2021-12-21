package io.reactive.programming.reactor;

import reactor.core.publisher.Mono;

public class MonoSubscriber {
    public static void main(String[] args) {
        //publisher
        Mono<Integer> orders = Mono.just("order:1")
                                  .map(word->word.length())
                                  .map(length->length/0);

        //orders.subscribe();
        orders.subscribe(
                System.out::println,
                error-> System.out.println(error.getMessage()),
                ()-> System.out.println("Completed")
        );
    }
}
