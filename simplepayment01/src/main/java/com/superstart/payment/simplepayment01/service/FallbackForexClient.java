package com.superstart.payment.simplepayment01.service;

import com.superstarbank.vomodel.forex.ForexFeedRequest;
import com.superstarbank.vomodel.forex.ForexFeedResponse;

import org.springframework.stereotype.Component;

@Component
public class FallbackForexClient implements ForexManagerAdvClient {

    @Override
    public ForexFeedResponse getFxRates(ForexFeedRequest fxReq) throws Exception {
        System.out.println("=================In my new fallback");
        return new ForexFeedResponse();
    }
    
}
