package io.reactive.programming.reactor.flux;

import io.reactive.programming.reactor.flux.subscriber.FluxSubscriber;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class StockSubscription {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger at=new AtomicInteger(100);

        List<Integer> list=new ArrayList<>();
        Flux.interval(Duration.ofSeconds(1))
                .map(i-> at.getAndAccumulate(FluxSubscriber.faker().random().nextInt(-5,5), Integer::sum))
                .subscribe(
                        (i)->{
                            System.out.println(LocalDateTime.now()+"-------->"+i);
                            list.add(i);
                            if(i<50){
                                System.out.println("Matched: "+i);
                            }
                        }
                        , RuntimeException::new
                        ,() -> {
                            System.out.println("MAX PRICE::"+list.stream().max(Comparator.naturalOrder()));
                            System.out.println("MIN PRICE::"+list.stream().min(Comparator.naturalOrder()));
                            System.out.println("Completed");
                        });

        FluxSubscriber.sleep(100);
    }
}
