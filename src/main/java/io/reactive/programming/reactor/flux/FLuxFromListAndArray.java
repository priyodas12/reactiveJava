package io.reactive.programming.reactor.flux;

import io.reactive.programming.reactor.flux.utility.FluxSubscriber;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class FLuxFromListAndArray {
    public static void main(String[] args) {
        List<String> listOfStrings=Arrays.asList("a","b","c",null);

        Integer [] ints={1,2,3,4};
        Flux.fromIterable(listOfStrings).subscribe(
                    FluxSubscriber.onNext(),
                    FluxSubscriber.onError(),
                    FluxSubscriber.onComplete());

        Flux.fromArray(ints).subscribe(
                FluxSubscriber.onNext(),
                FluxSubscriber.onError(),
                FluxSubscriber.onComplete());
    }
}
