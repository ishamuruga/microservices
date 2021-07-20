package com.superstart.payment.simplepayment01.api;

import java.util.ArrayList;
import java.util.List;

import com.superstarbank.vomodel.simplepayment.SimplePaymentRequest;


public class BaseController {
    protected List<SimplePaymentRequest> getListPayReqs() {

        List<SimplePaymentRequest> reqs = new ArrayList<>();

        for(int i=0;i<10;i++) {
            reqs.add(new SimplePaymentRequest(i,"test","test",100,"usd"));
            // public SimplePaymentRequest(int id, String srcAcct, String destAcct, int amount, String ccy)
        }

        return reqs;
    }
}
