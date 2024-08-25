/*
 * Author:  Priyobrato.Das
 * Generated: 8/26/24, 1:31 AM IST
 * Copyright (c)  2014-2024 priyodas12
 */

package io.reactive.programming.reactor.flux;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import io.reactive.programming.reactor.mono.util.SubscriberUtility;
import reactor.core.publisher.Flux;

public class NameGenerator {

  public static void main (String[] args) {

    //var list1 = getNamesList (10);
    getNamesFlux (10).subscribe (SubscriberUtility.onNext ());
    //System.out.println (list1);
    //System.out.println (list2);
  }

  public static Flux<String> getNamesFlux (int count) {
    return Flux.range (0, count)
        .map (i -> generateName ());
  }

  private static String generateName () {
    SubscriberUtility.sleepSomeTime (1);
    return SubscriberUtility.faker ().internet ().avatar ();
  }

  public static List<String> getNamesList (int count) {
    return IntStream.rangeClosed (0, count)
        .mapToObj (i -> generateName ())
        .collect (Collectors.toList ());
  }

}
