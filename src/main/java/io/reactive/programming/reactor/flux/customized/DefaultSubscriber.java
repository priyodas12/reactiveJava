package io.reactive.programming.reactor.flux.customized;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class DefaultSubscriber implements Subscriber {

    private String name="";

    public DefaultSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void onSubscribe(Subscription s) {
        s.request(Integer.MAX_VALUE);
    }

    @Override
    public void onNext(Object o) {
        System.out.println(name+" Received item::"+o.toString());
    }

    @Override
    public void onError(Throwable t) {
        System.out.println("Exception on "+name+", Message :"+t.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println(name+" Completed!");
    }

    public void sleep(int second){
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(second* 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
