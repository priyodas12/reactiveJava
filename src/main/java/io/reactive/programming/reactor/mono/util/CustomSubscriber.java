/*
 * Author:  Priyobrato.Das
 * Generated: 10/15/24, 12:59 PM IST
 * Copyright (c)  2014-2024 priyodas12
 */

package io.reactive.programming.reactor.mono.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;


public class CustomSubscriber implements Subscriber<Integer> {

  private final Logger log = LogManager.getLogger (CustomSubscriber.class);

  private Subscription subscription;

  private String name;
  public CustomSubscriber (String name) {
    this.name=name;
  }

  @Override
  public void onSubscribe(Subscription subscription) {
    this.subscription = subscription;
    log.info("{} : Subscription starts for {}",Thread.currentThread ().getName (),this.name);
    subscription.request (1);
  }


  @Override
  public void onNext (Integer integer) {
    log.info("{} : onNext: {}",Thread.currentThread ().getName (),integer.toString ());
  }

  @Override
  public void onError (Throwable throwable) {
    log.error("{} : onError: {}",Thread.currentThread ().getName (),
              throwable.getCause ().getMessage ());
  }

  @Override
  public void onComplete () {
    log.info("{} : onComplete",Thread.currentThread ().getName ());
  }
}
