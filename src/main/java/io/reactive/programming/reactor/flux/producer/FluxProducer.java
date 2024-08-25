/*
 * Author:  Priyobrato.Das
 * Generated: 8/26/24, 1:34 AM IST
 * Copyright (c)  2014-2024 priyodas12
 */

package io.reactive.programming.reactor.flux.producer;

import com.github.javafaker.Faker;

public class FluxProducer {

  public static final Faker FAKER = Faker.instance ();

  public static Faker faker () {
    return FAKER;
  }

  public static void sleep (int second) {
    System.out.println (Thread.currentThread ().getName ());
    try {
      Thread.sleep (second * 1000L);
    } catch (InterruptedException e) {
      e.printStackTrace ();
    }
  }
}
