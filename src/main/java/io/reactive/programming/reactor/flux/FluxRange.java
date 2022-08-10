package io.reactive.programming.reactor.flux;

import io.reactive.programming.reactor.flux.utility.FluxSubscriber;
import reactor.core.publisher.Flux;

public class FluxRange {
    public static void main(String[] args) {
        Flux.range(1,10)
                .map(i->FluxSubscriber.faker().name().fullName())
                .subscribe(FluxSubscriber.onNext());
    }
}
