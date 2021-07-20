package com.superstar.forex.forexfeed.api;

import java.util.Arrays;
import java.util.List;

import com.superstar.forex.forexfeed.service.FXFeedManager;
import com.superstarbank.vomodel.forex.ForexFeedRequest;
import com.superstarbank.vomodel.forex.ForexFeedResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/fx")
public class ForexFeedApi {

    @Autowired
    private FXFeedManager service;

    //api/fx
    @PostMapping(value = "/rates",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ForexFeedResponse> getFxRates(@RequestBody ForexFeedRequest fxReq) throws Exception {
        return new ResponseEntity<ForexFeedResponse>(service.getFxRates(fxReq),HttpStatus.OK);
    }

    @GetMapping(value = "/init",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> init() throws Exception {

        List<String> asList = Arrays.asList("Iam","Fine");

        return new ResponseEntity<List<String>>(asList,HttpStatus.OK);
    }
    

}
