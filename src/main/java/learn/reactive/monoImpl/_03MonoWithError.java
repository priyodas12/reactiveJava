/*
 * Author:  Priyobrato.Das
 * Generated: 10/01/24, 12:49 am IST
 * Copyright (c)  2014-2024 priyodas12
 */

package learn.reactive.monoImpl;

import reactor.core.publisher.Mono;

public class _03MonoWithError {

  public static void main(String[] args) {
    /**Publishers*/
    Mono<Integer> monoOne=Mono.just("172362881")
        .map(String::length)
        .map(n->n/0);

    //Consumer
    monoOne.subscribe(
        i-> System.out.println("Received:: "+i),
        err-> System.out.println("Error Encountered:: "+err),
        ()-> System.out.println("Completed")
    );
  }
}
