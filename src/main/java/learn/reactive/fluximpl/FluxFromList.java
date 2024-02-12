/*
 * Author:  Priyobrato.Das
 * Generated: 12/02/24, 10:55 pm IST
 * Copyright (c)  2014-2024 priyodas12
 */

package learn.reactive.fluximpl;

import java.util.List;
import learn.reactive.util.faker.FakerUtil;
import reactor.core.publisher.Flux;

public class FluxFromList {

  public static void main(String[] args) {

    Flux<Integer> fromListFlux= Flux.fromIterable(List.of(1,2,3,4,5,6));

    fromListFlux.subscribe(FakerUtil.onNext());

    Integer [] integers={1,2,3,4,5,6};

    Flux<Integer> fromArrayFlux= Flux.fromArray(integers);

    fromArrayFlux.subscribe(FakerUtil.onNext());

  }

}
