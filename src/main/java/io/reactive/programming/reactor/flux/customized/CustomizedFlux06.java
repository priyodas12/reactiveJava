package io.reactive.programming.reactor.flux.customized;

import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

public class CustomizedFlux06 {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
                    String name = Faker.instance().business().creditCardNumber();
                    System.out.println("Emitting ::"+name);
                    synchronousSink.next(name);
                    if(name.equalsIgnoreCase("1234-2121-1221-1211")){
                        synchronousSink.complete();
                    }
                }).subscribe(new DefaultSubscriber("Sub-3 "));
    }
}
