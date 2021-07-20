package com.superstart.payment.simplepayment01.service;

import com.superstarbank.vomodel.forex.ForexFeedRequest;
import com.superstarbank.vomodel.forex.ForexFeedResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "forex-service")
public interface ForexManagerClient {
    @RequestMapping(method = RequestMethod.POST, value = "api/fx/rates")
    public ForexFeedResponse getFxRates(ForexFeedRequest fxReq) throws Exception;
}


 //api/fx
 //@PostMapping(value = "/rates",produces = MediaType.APPLICATION_JSON_VALUE)
 //public ResponseEntity<ForexFeedResponse> getFxRates(@RequestBody ForexFeedRequest fxReq) throws Exception {
 //    return new ResponseEntity<ForexFeedResponse>(service.getFxRates(fxReq),HttpStatus.OK);
 //}
