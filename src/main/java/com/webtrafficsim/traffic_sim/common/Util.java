package com.webtrafficsim.traffic_sim.common;

import java.time.Duration;

import org.reactivestreams.Subscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Util {

    private static Logger log = LoggerFactory.getLogger(Util.class);

    public static <T> Subscriber<T> subscriber() {
        return new DefaultSubscriber<>("");
    }

    public static <T> Subscriber<T> subscriber(String name) {
        return new DefaultSubscriber<>(name);
    }

    public static void sleep(int n) {
        try {
            Thread.sleep(Duration.ofSeconds(n));
        } catch (InterruptedException e) {
           log.error("oops something went wrong", e);
        }
    }
}
