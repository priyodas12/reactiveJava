package io.reactive.programming.reactor.flux.customized;

import reactor.core.publisher.Flux;

public class CustomizedFlux03 {
    public static void main(String[] args) {
        Flux.range(0,10)
                .log()
                .take(3)//take 3rd item,cancel upstream subscription
                .log()
                .subscribe(new DefaultSubscriber("Default Sub-"));
    }
}
