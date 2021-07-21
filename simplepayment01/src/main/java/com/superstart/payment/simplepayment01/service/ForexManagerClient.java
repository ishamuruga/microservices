// package com.superstart.payment.simplepayment01.service;

// import com.superstarbank.vomodel.forex.ForexFeedRequest;
// import com.superstarbank.vomodel.forex.ForexFeedResponse;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.cloud.openfeign.FallbackFactory;
// import org.springframework.cloud.openfeign.FeignClient;
// import org.springframework.stereotype.Component;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;

// import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;



// @FeignClient(name = "forex-service123")
// public interface ForexManagerClient {

//     @RequestMapping(method = RequestMethod.POST, value = "api/fx/rates")
//     @CircuitBreaker(name = "test", fallbackMethod = "test2")
//     public ForexFeedResponse getFxRates(ForexFeedRequest fxReq) throws Exception;

//     default ForexFeedResponse test2(ForexFeedRequest fxReq,Throwable cause)  {
//         System.out.println("=================================in TEST2 Callbakc:-");

//         return new ForexFeedResponse();
//     }

// }


