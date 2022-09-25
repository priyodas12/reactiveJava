package io.reactive.programming.reactor.flux;

import io.reactive.programming.reactor.flux.utility.FluxSubscriber;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class FluxWithInterval {
    public static void main(String[] args) {
        Flux.interval(Duration.ofSeconds(2L))
                .subscribe(FluxSubscriber.onNext());

        FluxSubscriber.sleep(5);


    }
}
