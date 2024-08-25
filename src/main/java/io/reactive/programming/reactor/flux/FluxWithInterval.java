package io.reactive.programming.reactor.flux;

import java.time.Duration;

import io.reactive.programming.reactor.flux.subscriber.FluxSubscriber;
import reactor.core.publisher.Flux;

public class FluxWithInterval {

  public static void main (String[] args) {
    Flux.interval (Duration.ofSeconds (2L))
        .subscribe (FluxSubscriber.onNext ());

    FluxSubscriber.sleep (5);
  }
}
