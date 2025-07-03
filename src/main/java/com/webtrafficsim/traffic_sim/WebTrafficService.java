package com.webtrafficsim.traffic_sim;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

record WebTraffic(String url, String IP, long timeStamp) {}

@Service
public class WebTrafficService {

    private static Logger log = LoggerFactory.getLogger(WebTrafficService.class);

    public Flux<WebTraffic> webTrafficSim() {
        return Flux.defer(() -> {
            var isWebTrafficBurstPeriod = Faker.instance().random().nextBoolean();
            if (isWebTrafficBurstPeriod) {
                int burstCount = Faker.instance().random().nextInt(5, 120);
                log.info("Starting web traffic burst of {} events", burstCount);
                return generateWebTrafficBurst(burstCount);
            } else {
                int steadyCount = Faker.instance().random().nextInt(1, 25);
                log.info("Starting steady web traffic of {} events", steadyCount);
                return generateSteadyFlowOfTraffic(steadyCount);
            }
        }).repeat();
    }

    private Flux<WebTraffic> generateWebTrafficBurst(int count) {
        return Flux.range(0, count)
                .concatMap(i -> {
                    var event = generateEvent();
                    return Mono.delay(Duration.ofMillis(Faker.instance().random().nextInt(5, 70))).thenReturn(event);
                });
    }

    private Flux<WebTraffic> generateSteadyFlowOfTraffic(int count) {
        return Flux.range(0, count)
                .concatMap(i -> {
                    var event = generateEvent();
                    return Mono.delay(Duration.ofMillis(Faker.instance().random().nextInt(500, 1050)))
                            .thenReturn(event);
                });
    }

    private WebTraffic generateEvent() {
        String url = Faker.instance().internet().url();
        String ip = Faker.instance().internet().ipV4Address();
        long timeStamp = System.currentTimeMillis();
        return new WebTraffic(url, ip, timeStamp);
    }
}
