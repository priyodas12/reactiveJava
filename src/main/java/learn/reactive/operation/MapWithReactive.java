/*
 * Author:  Priyobrato.Das
 * Generated: 10/1/24, 11:16 PM IST
 * Copyright (c)  2014-2024 priyodas12
 */

package learn.reactive.operation;

import com.github.javafaker.Faker;

import learn.reactive.util.faker.FakerUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MapWithReactive {

  public static void main (String[] args) {
    MapWithReactive mwr = new MapWithReactive ();
    mwr.nameFlux ().subscribe (System.out::println);
    mwr.nameFlux_immutable ().subscribe (System.out::println);
  }

  public Flux<String> nameFlux () {
    return Flux.fromIterable (FakerUtil.getNames ())
        .map (String::toUpperCase)
        .log ();
  }

  //reactive stream are immutable
  public Flux<String> nameFlux_immutable () {
    var names = Flux.fromIterable (FakerUtil.getNames ());

    names.map (String::toUpperCase);

    return names;
  }


  public Mono<String> nameMono () {
    return Mono.just (Faker.instance ().name ().fullName ());
  }
}
