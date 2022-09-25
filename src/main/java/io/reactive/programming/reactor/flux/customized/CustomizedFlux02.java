package io.reactive.programming.reactor.flux.customized;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.util.context.Context;

import java.util.function.LongConsumer;
import java.util.stream.IntStream;

public class CustomizedFlux02 {
    public static void main(String[] args) {

        FluxSink<String> fluxSink=new FluxSink<String>() {

            @Override
            public FluxSink<String> next(String s) {
                System.out.println("CustomizedFlux02.next");
                return null;
            }

            @Override
            public void complete() {
                System.out.println("CustomizedFlux02.complete");
            }

            @Override
            public void error(Throwable throwable) {
                System.out.println("CustomizedFlux02.error");
            }

            @Override
            public Context currentContext() {
                System.out.println("CustomizedFlux02.currentContext");
                return null;
            }

            @Override
            public long requestedFromDownstream() {
                System.out.println("CustomizedFlux02.requestedFromDownstream");
                return 0;
            }

            @Override
            public boolean isCancelled() {
                System.out.println("CustomizedFlux02.isCancelled");
                return false;
            }

            @Override
            public FluxSink<String> onRequest(LongConsumer longConsumer) {
                System.out.println("CustomizedFlux02.onRequest");
                return null;
            }

            @Override
            public FluxSink<String> onCancel(Disposable disposable) {
                System.out.println("CustomizedFlux02.onCancel");
                return null;
            }

            @Override
            public FluxSink<String> onDispose(Disposable disposable) {
                System.out.println("CustomizedFlux02.onDispose");
                return null;
            }
        };

        //producer
        NameProducer nameProducer=new NameProducer(fluxSink);

        //subscriber
        DefaultSubscriber defaultSubscriber=new DefaultSubscriber("GOT.SUB ");

        Flux.create(nameProducer)
                .subscribe(defaultSubscriber);

        //producer thread
        Runnable r= nameProducer::produce;

        IntStream.rangeClosed(0,10).forEach(i->{
            new Thread(r).start();
        });

        defaultSubscriber.sleep(2);

    }
}
