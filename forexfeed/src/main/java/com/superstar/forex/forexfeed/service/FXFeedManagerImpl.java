package com.superstar.forex.forexfeed.service;

import java.math.BigDecimal;

import com.superstar.forex.forexfeed.exception.NoForexFeedException;
import com.superstarbank.vomodel.forex.ForexFeedRequest;
import com.superstarbank.vomodel.forex.ForexFeedResponse;

import org.springframework.stereotype.Service;

@Service
public class FXFeedManagerImpl extends BaseFxSource implements FXFeedManager {

    

    @Override
    public ForexFeedResponse getFxRates(ForexFeedRequest fxReq) throws Exception {
        
        ForexFeedResponse fxRes = new ForexFeedResponse();
        
        String key = fxReq.getDestCcy().concat(fxReq.getSrcCcy());

        BigDecimal fxRate = new BigDecimal(0);
        System.out.println(key);
        if (getFXRatesData().containsKey(key)){
            fxRate = getFXRatesData().get(key);
        } else {
            throw new NoForexFeedException("No Forex Feed available");
        }

        fxRes.setFxReq(fxReq);
        fxRes.setValue(fxRate.multiply(new BigDecimal(fxReq.getAmount())));
        
        return fxRes;
    }
    
}
