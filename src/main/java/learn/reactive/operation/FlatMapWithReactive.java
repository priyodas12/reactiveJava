/*
 * Author:  Priyobrato.Das
 * Generated: 10/1/24, 11:32 PM IST
 * Copyright (c)  2014-2024 priyodas12
 */

package learn.reactive.operation;

import com.github.javafaker.Faker;

import learn.reactive.util.faker.FakerUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FlatMapWithReactive {

  public static void main (String[] args) {
    FlatMapWithReactive flatMapWithReactive = new FlatMapWithReactive ();
    flatMapWithReactive.nameFlux (10).subscribe (System.out::println);
  }

  //always return Flux.of(T)
  public Flux<String> nameFlux (int i) {
    return Flux.fromIterable (FakerUtil.getNames ())
        .filter (s -> s.length () <= i)
        .flatMap (s -> Flux.fromArray (s.split ("")))
        .log ();
  }

  public Mono<String> nameMono () {
    return Mono.just (Faker.instance ().name ().fullName ());
  }

}
