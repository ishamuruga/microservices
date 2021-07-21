package com.superstart.payment.simplepayment01.service;

import com.superstarbank.vomodel.forex.ForexFeedRequest;
import com.superstarbank.vomodel.forex.ForexFeedResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import feign.Feign;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
//import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
// import lombok.RequiredArgsConstructor;

@FeignClient(name = ForexManagerAdvClient.SERVICE_NAME, configuration = FeignConfig.class)
public interface ForexManagerAdvClient {

    String SERVICE_NAME = "forex-service";


    @RequestMapping(method = RequestMethod.POST, value = "api/fx/rates")
    @CircuitBreaker(name = SERVICE_NAME)
    public ForexFeedResponse getFxRates(ForexFeedRequest fxReq) throws Exception;

}

// CircuitBreaker circuitBreaker = CircuitBreaker.ofDefaults("backendName");
// RateLimiter rateLimiter = RateLimiter.ofDefaults("backendName");
// FeignDecorators decorators = FeignDecorators.builder()
//                                  .withRateLimiter(rateLimiter)
//                                  .withCircuitBreaker(circuitBreaker)
//                                  .build();
// MyService myService = Resilience4jFeign.builder(decorators).target(MyService.class, "http://localhost:8080/")

