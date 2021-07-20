package com.superstar.forex.forexfeed.service;

import com.superstarbank.vomodel.forex.ForexFeedRequest;
import com.superstarbank.vomodel.forex.ForexFeedResponse;

public interface FXFeedManager {
    public ForexFeedResponse getFxRates(ForexFeedRequest fxReq) throws Exception;
}
