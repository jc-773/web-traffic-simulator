package com.webtrafficsim.traffic_sim;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class WebTrafficController {

    private WebTrafficService webTrafficService;

    @Autowired
    public WebTrafficController(WebTrafficService webTrafficService) {
        this.webTrafficService = webTrafficService;
    }

    @GetMapping(value = "/sim/web/traffic", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<WebTraffic> getWebTrafficSimulationController() {
        return webTrafficService.webTrafficSim();
    }
}
