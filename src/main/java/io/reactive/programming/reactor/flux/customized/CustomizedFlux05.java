package io.reactive.programming.reactor.flux.customized;

import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

public class CustomizedFlux05 {
    public static void main(String[] args) {

        Flux.generate(synchronousSink ->{
                synchronousSink.next(Faker.instance().ancient().god().toString());
                //synchronousSink.next(Faker.instance().ancient().god().toString());//more than one not allowed

                //synchronousSink.error(new RuntimeException("synchronousSink error!"));

                //synchronousSink.complete(); // complete() will pass single element then take() will not able to pass 1st 3 elements
                })
                .take(10)//provide limit unless it will be keep on emitting
                .subscribe(new DefaultSubscriber("SUB-02")
                );

    }
}
