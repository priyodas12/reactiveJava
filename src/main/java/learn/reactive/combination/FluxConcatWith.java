/*
 * Author:  Priyobrato.Das
 * Generated: 10/1/24, 11:47 PM IST
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

public class FluxConcatWith {

  //subscription values comes one after another
  public static void main (String[] args) throws InterruptedException {
    FluxConcatWith c = new FluxConcatWith ();

    var responseOne = Flux.fromIterable (c.getApiResponse ())
        .map (s -> s.concat ("-> from 1"))
        .delayElements (Duration.ofMillis (300));

    var responseTwo = Flux.fromIterable (FakerUtil.getNames ())
        .map (s -> s.concat ("-> from 2"))
        .delayElements (Duration.ofMillis (200));

    var combinedResponse =
        responseOne.concatWith (responseTwo);

    combinedResponse.subscribe (System.out::println);

    var responseThree = Flux.fromIterable (c.getApiResponse ())
        .map (s -> s.concat ("-> from 3"))
        .delayElements (Duration.ofMillis (300));

    var responseFour = Flux.fromIterable (FakerUtil.getNames ())
        .map (s -> s.concat ("-> from 4"))
        .delayElements (Duration.ofMillis (200));

    var combinedResponseAnother =
        Flux.concat (responseThree, responseFour);

    combinedResponseAnother.subscribe (System.out::println);

    Thread.sleep (Duration.ofSeconds (30));

  }

  public List<String> getApiResponse () {
    return IntStream.rangeClosed (1, 10)
        .mapToObj (n -> Faker.instance ().funnyName ().name ())
        .collect (Collectors.toList ());
  }
}
