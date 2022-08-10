package io.reactive.programming.reactor.mono;

import com.github.javafaker.Faker;
import io.reactive.programming.reactor.mono.util.SubscriberUtility;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class MonoWithFuture {
    public static void main(String[] args) {
        Mono.fromFuture(getName())
        .subscribe(
                SubscriberUtility.onNext(),
                SubscriberUtility.onError(),
                SubscriberUtility.onComplete());

        SubscriberUtility.sleepSomeTime(2);
    }

    private static CompletableFuture<String> getName(){
        return CompletableFuture.supplyAsync(()-> Faker.instance().name().fullName());
    }
}
