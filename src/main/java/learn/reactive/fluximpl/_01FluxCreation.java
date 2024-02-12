/*
 * Author:  Priyobrato.Das
 * Generated: 12/02/24, 10:32 pm IST
 * Copyright (c)  2014-2024 priyodas12
 */

package learn.reactive.fluximpl;

import java.util.List;
import learn.reactive.util.faker.FakerUtil;
import reactor.core.publisher.Flux;

public class _01FluxCreation {

  public static void main(String[] args) {
    Flux<Object> fluxSource= Flux.just(1L,true,"test", List.of(12,23,34));

    fluxSource.subscribe(
        FakerUtil.onNext(),
        FakerUtil.onError(),
        FakerUtil.onComplete()
    );
  }

}
