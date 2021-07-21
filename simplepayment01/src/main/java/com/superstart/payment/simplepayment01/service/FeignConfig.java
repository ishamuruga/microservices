package com.superstart.payment.simplepayment01.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import feign.Feign;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import io.github.resilience4j.ratelimiter.RateLimiter;

@Configuration
public class FeignConfig {

    @Autowired
    private CircuitBreakerRegistry registry;

    @Autowired
    private FallbackForexClient fallbackProducerClient;
    
    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        
        CircuitBreaker circuitBreaker = CircuitBreaker.ofDefaults("forex-service");
        RateLimiter rateLimiter = RateLimiter.ofDefaults("forex-service");
        FeignDecorators decorators = FeignDecorators.builder()
                                         .withRateLimiter(rateLimiter)
                                         .withCircuitBreaker(circuitBreaker)
                                         .withFallback(fallbackProducerClient)
                                         .build();

        return Resilience4jFeign.builder(decorators);

        //CircuitBreaker circuitBreaker = registry.circuitBreaker("forex-service");
        //FeignDecorators decorators = FeignDecorators.builder()
        //        .withCircuitBreaker(circuitBreaker)
        //        .withFallback(fallbackProducerClient)
        //        .build();
        //return Resilience4jFeign.builder(decorators);
    }
}
