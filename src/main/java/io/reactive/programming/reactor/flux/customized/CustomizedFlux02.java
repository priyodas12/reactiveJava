package io.reactive.programming.reactor.flux.customized;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.util.context.Context;

import java.util.function.LongConsumer;

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

        NameProducer nameProducer=new NameProducer(fluxSink);

        Flux.create(nameProducer)
                .subscribe(new DefaultSubscriber("GOT-01-Characters, "));

        nameProducer.produce();
    }
}
