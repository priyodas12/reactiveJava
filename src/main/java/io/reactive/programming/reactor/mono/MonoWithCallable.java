package io.reactive.programming.reactor.mono;

import com.github.javafaker.Faker;
import io.reactive.programming.reactor.mono.util.SubscriberUtility;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.concurrent.Callable;

public class MonoWithCallable {
    public static void main(String[] args) {
        Callable<String> stringCallable= MonoWithCallable::getName;
        Mono.fromCallable(stringCallable)
                .subscribe(
                 SubscriberUtility.onNext(),
                 SubscriberUtility.onError(),
                 SubscriberUtility.onComplete()
                );
    }
    private static String getName(){
        System.out.println("Generating name..."+new Date());
        return Faker.instance().funnyName().name();
    }
}
