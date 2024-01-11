/*
 * Author:  Priyobrato.Das
 * Generated: 11/01/24, 11:50 pm IST
 * Copyright (c)  2014-2024 priyodas12
 */

package learn.reactive.monoImpl;

import learn.reactive.monoImpl.faker.FakerUtil;
import reactor.core.publisher.Mono;

public class _05MonoJustOrSupplier {

  public static void main(String[] args) {

    //Mono.just()->if you have some data ready to publish
    Mono<String> derivedName=Mono.just(getNames());
    derivedName.subscribe(
        FakerUtil.onNext()
    );

    //Supplier could be used to provide values lazily
    Mono<String> supplierMono=Mono.fromSupplier(_05MonoJustOrSupplier::getNames);
    supplierMono.subscribe(
        FakerUtil.onNext()
    );
  }

  public static String getNames(){
    System.out.println("name generating...");
    return FakerUtil.getFakeInstance().name().nameWithMiddle();
  }

}
