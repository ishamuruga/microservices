package com.superstar.forex.forexfeed.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BaseFxSource {
    protected Map<String,BigDecimal> getFXRatesData(){
        Map<String,BigDecimal> mpRates = new HashMap<>();
        mpRates.put("USDINR", new BigDecimal("72.53"));
        mpRates.put("JPYINR", new BigDecimal("172.53"));
        mpRates.put("EURINR", new BigDecimal("91.53"));
        mpRates.put("SIGINR", new BigDecimal("50.53"));
        mpRates.put("AUDINR", new BigDecimal("44.53"));

        return mpRates;
    }
}
