package io.reactive.programming.reactor.flux;

import io.reactive.programming.reactor.flux.utility.FluxSubscriber;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FluxWithStream {
    public static void main(String[] args) {
        List<Integer> integerList=Arrays.asList(1,2,3,4,5,6,7);

        Stream<Integer> integerStream= integerList.stream();

        //integerStream.forEach(System.out::println);
        //integerStream.forEach(System.out::println);

        Flux<Integer> integerFlux1=Flux.fromStream(integerStream);

        integerFlux1.subscribe(
                FluxSubscriber.onNext(),
                FluxSubscriber.onError(),
                FluxSubscriber.onComplete());

        integerFlux1.subscribe(
                FluxSubscriber.onNext(),
                FluxSubscriber.onError(),
                FluxSubscriber.onComplete());

        Flux<Integer> integerFlux2=Flux.fromStream(() -> integerList.stream());

        integerFlux2.subscribe(
                FluxSubscriber.onNext(),
                FluxSubscriber.onError(),
                FluxSubscriber.onComplete());

        integerFlux2.subscribe(
                FluxSubscriber.onNext(),
                FluxSubscriber.onError(),
                FluxSubscriber.onComplete());
    }
}
