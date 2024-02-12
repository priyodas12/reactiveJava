/*
 * Author:  Priyobrato.Das
 * Generated: 12/02/24, 10:41 pm IST
 * Copyright (c)  2014-2024 priyodas12
 */

package learn.reactive.fluximpl;

import learn.reactive.util.faker.FakerUtil;
import reactor.core.publisher.Flux;

public class FluxMultipleSubscriber {

  public static void main(String[] args) {

    Flux<Integer> integerFlux=Flux.just(1,2,3,4);

    Flux<Integer> evenFlux= integerFlux.filter(i->i%2==0);

    Flux<Integer> oddFlux=integerFlux.filter(i->i%2==1);

    evenFlux.subscribe(i-> System.out.println("Received Even Number:: "+i));
    oddFlux.subscribe(i-> System.out.println("Received Odd Number:: "+i));
  }

}
