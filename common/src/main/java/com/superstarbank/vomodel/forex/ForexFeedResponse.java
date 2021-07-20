package com.superstarbank.vomodel.forex;

import java.math.BigDecimal;

import com.superstarbank.vomodel.BaseVo;

public class ForexFeedResponse extends BaseVo {
    
    private ForexFeedRequest fxReq;

    private BigDecimal value;

    public ForexFeedRequest getFxReq() {
        return fxReq;
    }

    public void setFxReq(ForexFeedRequest fxReq) {
        this.fxReq = fxReq;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal bigDecimal) {
        this.value = bigDecimal;
    }

    @Override
    public String toString() {
        return "ForexFeedResponse [fxReq=" + fxReq + ", value=" + value + "]";
    }

    
}
