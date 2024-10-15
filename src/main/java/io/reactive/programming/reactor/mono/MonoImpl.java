package io.reactive.programming.reactor.mono;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.reactivestreams.Subscription;

import io.reactive.programming.reactor.mono.util.CustomSubscriber;
import io.reactive.programming.reactor.mono.util.SubscriberUtility;
import reactor.core.publisher.Mono;

public class MonoImpl {

    public static void main(String[] args) throws InterruptedException {

        //publisher(interface)
        Mono<Integer> integerMono = Mono.just(5);
        //nothing happen until subscribe
        integerMono.subscribe (new CustomSubscriber ("custom-subscriber-01"));
        //System.out.println(integerMono);

        //Thread.sleep (10000);
    }
}
