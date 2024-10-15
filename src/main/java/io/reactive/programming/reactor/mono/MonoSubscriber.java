package io.reactive.programming.reactor.mono;

import io.reactive.programming.reactor.mono.util.CustomSubscriber;
import reactor.core.publisher.Mono;

public class MonoSubscriber {

  public static void main (String[] args) {
    //publisher
    Mono<Integer> orders = Mono.just ("order:1")
        .map (String::length)
        .map (length -> length / 0);

    //orders.subscribe();
    orders.subscribe (
        new CustomSubscriber ("CS-01"));
  }
}
