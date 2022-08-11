package io.reactive.programming.reactor.flux.utility;

import com.github.javafaker.Faker;

import java.util.Date;
import java.util.function.Consumer;

public class FluxSubscriber {

    public static final Faker FAKER = Faker.instance();

    public static Consumer<Object> onNext(){
        return o -> System.out.println("Received Value: "+o);
    }

    public static Consumer<Throwable> onError(){
        return o -> System.out.println("Error Message : "+o.getMessage());
    }

    public static Runnable onComplete(){
        return  () -> System.out.println("Completed at "+new Date());
    }

    public static Faker faker(){
        return FAKER;
    }

    public static void sleep(int second){
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(second* 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

