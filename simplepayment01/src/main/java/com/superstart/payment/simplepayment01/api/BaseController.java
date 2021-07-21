package com.superstart.payment.simplepayment01.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.superstarbank.vomodel.simplepayment.SimplePaymentRequest;


public class BaseController {
    protected List<SimplePaymentRequest> getListPayReqs() {
        List<SimplePaymentRequest> reqs = new ArrayList<>();
        for(int i=0;i<10;i++) {
            // SimplePaymentRequest spr = new SimplePaymentRequest();
            // spr.setAmount(i);
            // spr.setCcy("usd");
            // spr.setDestAcct("232323232");
            // spr.setSrcAcct("8787877");
            // spr.setTs(new Date());    
            // reqs.add(spr);
            
        }

        return reqs;
    }
}
