package io.reactive.programming.reactor.flux.utility;

import java.util.Date;
import java.util.function.Consumer;

public class FluxSubscriber {

    public static Consumer<Object> onNext(){
        return o -> System.out.println("Received Value: "+o);
    }

    public static Consumer<Throwable> onError(){
        return o -> System.out.println("Error Message : "+o.getMessage());
    }

    public static Runnable onComplete(){
        return  () -> System.out.println("Completed at "+new Date());
    }

}

