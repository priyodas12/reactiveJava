package io.reactive.programming.reactor.flux.customized;

import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

import java.util.stream.IntStream;

public class CustomizedFlux04 {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
           int count=0;
               do{
                 String name=Faker.instance().animal().name();
                 System.out.println("generating "+name);
                 fluxSink.next(name);
                 count++;
               }while(count<20 && !fluxSink.isCancelled());
           fluxSink.complete();
        }).take(3)
          .subscribe(new DefaultSubscriber("Sub 01 "));
    }
}
