/*
 * Author:  Priyobrato.Das
 * Generated: 10/1/24, 11:27 PM IST
 * Copyright (c)  2014-2024 priyodas12
 */

package learn.reactive.operation;

import com.github.javafaker.Faker;

import learn.reactive.util.faker.FakerUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FilterWithReactive {

  public static void main (String[] args) {
    FilterWithReactive filterWithReactive = new FilterWithReactive ();
    filterWithReactive.nameFlux (9).subscribe (System.out::println);
  }

  public Flux<String> nameFlux (int i) {
    return Flux.fromIterable (FakerUtil.getNames ())
        .filter (s -> s.length () <= i)
        .map (String::toUpperCase)
        .log ();
  }

  public Mono<String> nameMono () {
    return Mono.just (Faker.instance ().name ().fullName ());
  }

}
