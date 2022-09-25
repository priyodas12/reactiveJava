package io.reactive.programming.reactor.flux.customized;

import com.github.javafaker.Faker;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class NameProducer implements Consumer<FluxSink<String>> {

    private FluxSink<String> fluxSink;

    public NameProducer(FluxSink<String> fluxSink) {
        this.fluxSink = fluxSink;
    }

    @Override
    public void accept(FluxSink<String> stringFluxSink) {
        System.out.println("NameProducer.accept()");
        this.fluxSink = stringFluxSink;
    }

    public void produce() {
        System.out.println("NameProducer.produce()");
        String name= Faker.instance().gameOfThrones().character();
        Thread thread=Thread.currentThread();
        this.fluxSink.next(name+" printed by , "+thread.getName());
    }

}
