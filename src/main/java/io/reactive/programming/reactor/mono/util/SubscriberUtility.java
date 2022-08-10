package io.reactive.programming.reactor.mono.util;

import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.function.Consumer;


public class SubscriberUtility {

    public static final Faker FAKER = Faker.instance();

    public static Consumer<Object> onNext(){
        return o -> System.out.println("Received : "+o);
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

    public static void sleepSomeTime(int second){
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(second* 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
