package io.reactive.programming.reactor.flux.customized;

import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

import java.util.stream.IntStream;

public class CustomizedFlux01 {
    public static void main(String[] args) {

        Flux.create(fluxSink -> {
            IntStream.rangeClosed(0,10)
                    .forEach(i->fluxSink.next(Faker.instance().random().nextInt(i,20)));
                    fluxSink.complete();
        })
        .subscribe(new DefaultSubscriber("sub-test01"));


    }
}
