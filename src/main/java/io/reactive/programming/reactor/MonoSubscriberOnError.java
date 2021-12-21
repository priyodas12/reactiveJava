package io.reactive.programming.reactor;

import io.reactive.programming.reactor.util.SubscriberUtility;
import reactor.core.publisher.Mono;

import java.util.stream.IntStream;

public class MonoSubscriberOnError {
    public static void main(String[] args) {
        userRepository(25)
                .subscribe(
                        SubscriberUtility.onNext(),
                        SubscriberUtility.onError(),
                        SubscriberUtility.onComplete()
                );
    }

    private static Mono<String> userRepository(int userId){
        Long presentIn10=IntStream.rangeClosed(0,10).filter(i->i==userId).count();
        Long absentIn20=IntStream.rangeClosed(10,20).filter(i->i==userId).count();
        if(presentIn10.intValue()>0) {
            String user = SubscriberUtility.faker().funnyName().name();
            return Mono.just(user);
        }else if(absentIn20.intValue()>0){
            return Mono.empty();
        }else{
            return Mono.error(new RuntimeException("No USER FOUND!"));
        }
    }
}
