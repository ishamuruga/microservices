package com.superstart.payment.simplepayment01.api;

import java.util.Date;
import java.util.List;

import com.netflix.discovery.converters.Auto;
import com.superstarbank.vomodel.forex.ForexFeedRequest;
import com.superstarbank.vomodel.forex.ForexFeedResponse;
import com.superstarbank.vomodel.simplepayment.SimplePaymentRequest;
import com.superstarbank.vomodel.simplepayment.SimplePaymentResponse;
import com.superstart.payment.simplepayment01.service.DoPaymentsManager;
import com.superstart.payment.simplepayment01.service.ForexManagerAdvClient;
//import com.superstart.payment.simplepayment01.service.ForexManagerClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;

@RestController
@RequestMapping("api")
public class SimplePaymentsController extends BaseController {

    @Autowired
    private ForexManagerAdvClient fxClient;

    @Autowired
    private DoPaymentsManager service;

    @GetMapping(value = "/names", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SimplePaymentRequest>> getList() {
        callForex();
        return new ResponseEntity(this.getListPayReqs(), HttpStatus.OK);
    }

    @PostMapping(value = "/doPayments", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SimplePaymentResponse> doPayment(@RequestBody SimplePaymentRequest payReq) throws Exception {
        System.out.println("=====================in DO Payments Controller...");
        return new ResponseEntity<SimplePaymentResponse>(service.doPayments(payReq), HttpStatus.OK);
    }


    //@Bulkhead(name = "callForex", fallbackMethod = "fallback1")
    public String callForex() {
        System.out.println("=========================Forex Call"); 
        ForexFeedRequest fxReq = new ForexFeedRequest();
        fxReq.setAmount(200);
        fxReq.setDestCcy("USD");
        fxReq.setSrcCcy("INR");
        fxReq.setTs(new Date());

        ForexFeedResponse fxRes = null;
        try {
            fxRes = fxClient.getFxRates(fxReq);
        } catch (Exception e) {
            System.out.println("ERR in Field Client..." + e.toString());
            e.printStackTrace();
        }
        System.out.println(fxRes);

        return fxRes.toString();
    }

    // public String fallback1(Throwable throwable) {
    //     // fallback logic for test2.
    //     System.out.println("=========================fallback");
    //     System.out.println(throwable.toString());
    //     return "ERROR";
    // }
}
