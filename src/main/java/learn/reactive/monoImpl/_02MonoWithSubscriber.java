/*
 * Author:  Priyobrato.Das
 * Generated: 10/01/24, 12:32 am IST
 * Copyright (c)  2014-2024 priyodas12
 */

package learn.reactive.monoImpl;

import reactor.core.publisher.Mono;

public class _02MonoWithSubscriber {

  public static void main(String[] args) {

    /**Publishers*/
    Mono<Integer> monoOne=Mono.just(120);

    //1
    monoOne.subscribe(
        i-> System.out.println("Received:: "+i),
        err-> System.out.println("Error Encountered:: "+err),
        ()-> System.out.println("Completed")
    );
  }

}
