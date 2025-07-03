package com.webtrafficsim.traffic_sim.common;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultSubscriber<T> implements Subscriber <T> {

    private static Logger log = LoggerFactory.getLogger(DefaultSubscriber.class);

    private String name; 

    public DefaultSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void onSubscribe(Subscription s) {
        s.request(Integer.MAX_VALUE);
    }

    @Override
    public void onNext(T t) {
         log.info("{}", t);
    }

    @Override
    public void onError(Throwable t) {
         log.error(name, t);
    }

    @Override
    public void onComplete() {
         log.info("{}, completed", name);
    }
}
