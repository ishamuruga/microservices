package com.superstarbank.vomodel.forex;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.superstarbank.vomodel.BaseVo;

public class ForexFeedRequest extends BaseVo {
    private int id;

    private String srcCcy;

    private String destCcy;

    private int amount;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date ts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSrcCcy() {
        return srcCcy;
    }

    public void setSrcCcy(String srcCcy) {
        this.srcCcy = srcCcy;
    }

    public String getDestCcy() {
        return destCcy;
    }

    public void setDestCcy(String destCcy) {
        this.destCcy = destCcy;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    @Override
    public String toString() {
        return "ForexFeedRequest [amount=" + amount + ", destCcy=" + destCcy + ", id=" + id + ", srcCcy=" + srcCcy
                + ", ts=" + ts + "]";
    }

    
}
