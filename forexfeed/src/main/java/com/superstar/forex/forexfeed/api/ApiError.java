package com.superstar.forex.forexfeed.api;

import java.util.Date;

public class ApiError {
    private Date ts;

    private String desc;

    private String app;

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    @Override
    public String toString() {
        return "ApiError [app=" + app + ", desc=" + desc + ", ts=" + ts + "]";
    }


}
