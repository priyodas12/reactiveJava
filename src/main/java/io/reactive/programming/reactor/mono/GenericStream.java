package io.reactive.programming.reactor.mono;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class GenericStream {
    public static void main(String[] args) {
        Stream<Integer> integerStream=Stream.of(1000)
                                            .map(number->{
                                                try {
                                                    TimeUnit.MILLISECONDS.sleep(2000);
                                                } catch (InterruptedException e) {
                                                    e.printStackTrace();
                                                }
                                                return number*2;
                                            });

        //System.out.println(integerStream.findFirst().get());
        integerStream.forEach(System.out::println);
    }
}
