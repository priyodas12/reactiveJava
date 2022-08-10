package io.reactive.programming.reactor.mono;

import com.github.javafaker.Faker;
import reactor.core.publisher.Mono;

import java.util.Date;

public class MonoWithSupplier {
    public static void main(String[] args) {
        //eager loading:1st line of getName() will execute
        //Mono<String> simpleMono=Mono.just(getName());

        //until there is no subscriber any line of getName() will not execute
        Mono<String> supplierMono=Mono.fromSupplier(()->getName());
        supplierMono.subscribe(System.out::println);
    }

    private static String getName(){
        System.out.println("Generating name..."+new Date());
        return Faker.instance().funnyName().name();
    }
}
