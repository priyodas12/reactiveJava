/*
 * Author:  Priyobrato.Das
 * Generated: 10/01/24, 12:06 am IST
 * Copyright (c)  2014-2024 priyodas12
 */

package learn.reactive.monoImpl;


import java.util.stream.Stream;
import reactor.core.publisher.Mono;

public class _01MonoBasics {

  public static void main(String[] args) {

    /**Stream approach*/
    Stream<Integer> integerStream=Stream.of(1)
        .map(i->{
          try {
            Thread.sleep(2000);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
          return i*20;
          }
        );

    System.out.println(integerStream);

    integerStream.forEach(System.out::println);

    /**Publish single element with mono*/
    Mono<Integer> mono=Mono.just(112);

    mono.subscribe(integer -> System.out.println("Received:: "+integer));
  }
}
