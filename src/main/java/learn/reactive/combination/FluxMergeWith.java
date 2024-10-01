/*
 * Author:  Priyobrato.Das
 * Generated: 10/2/24, 12:05 AM IST
 * Copyright (c)  2014-2024 priyodas12
 */

package learn.reactive.combination;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.github.javafaker.Faker;

import learn.reactive.util.faker.FakerUtil;
import reactor.core.publisher.Flux;


public class FluxMergeWith {

  public static void main (String[] args) throws InterruptedException {
    FluxMergeWith fluxMergeWith = new FluxMergeWith ();

    var publisher1 = Flux.fromIterable (fluxMergeWith.getApiResponse ())
        .map (s -> "pub3: " + s)
        .delayElements (Duration.ofMillis (300));

    var publisher2 = Flux.fromIterable (FakerUtil.getNames ())
        .map (s -> "pub4: " + s)
        .delayElements (Duration.ofMillis (300));

    var combinedPublisher =
        publisher1.mergeWith (publisher2);

    combinedPublisher.subscribe (System.out::println);

    Thread.sleep (Duration.ofSeconds (10));
  }

  public List<String> getApiResponse () {
    return IntStream.rangeClosed (1, 10)
        .mapToObj (n -> Faker.instance ().funnyName ().name ())
        .collect (Collectors.toList ());
  }
}


