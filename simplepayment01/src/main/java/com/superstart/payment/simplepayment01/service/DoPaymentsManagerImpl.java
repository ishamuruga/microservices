package com.superstart.payment.simplepayment01.service;

import java.util.Date;

import com.superstarbank.vomodel.forex.ForexFeedRequest;
import com.superstarbank.vomodel.forex.ForexFeedResponse;
import com.superstarbank.vomodel.simplepayment.SimplePaymentRequest;
import com.superstarbank.vomodel.simplepayment.SimplePaymentResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.net.SyslogOutputStream;

@Service
public class DoPaymentsManagerImpl implements DoPaymentsManager {

    @Autowired
    private ForexManagerAdvClient fxClient;

    @Override
    public SimplePaymentResponse doPayments(SimplePaymentRequest payReq) throws Exception {

        SimplePaymentResponse payRes = new SimplePaymentResponse();
        payRes.setsPayRequest(payReq);

        if (payReq.getCcy().equalsIgnoreCase("INR")) {
            payRes.setStatus(true);
            payRes.setTxnRefNumber("LOCAL-TXN-" + System.currentTimeMillis());
        } else {
            payRes.setStatus(true);
            payRes.setTxnRefNumber("CROSS-CCY-TXN-" + System.currentTimeMillis());

            ForexFeedRequest fxReq = new ForexFeedRequest();
            fxReq.setAmount(payReq.getAmount());
            fxReq.setDestCcy(payReq.getCcy());
            fxReq.setSrcCcy("INR");
            fxReq.setTs(new Date());

            ForexFeedResponse fxRes = fxClient.getFxRates(fxReq);
            System.out.println(fxRes);
            payRes.setAmount(fxRes.getValue());

        } 

        return payRes;
    }

}
