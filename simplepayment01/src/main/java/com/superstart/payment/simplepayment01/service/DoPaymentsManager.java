package com.superstart.payment.simplepayment01.service;

import com.superstarbank.vomodel.simplepayment.SimplePaymentRequest;
import com.superstarbank.vomodel.simplepayment.SimplePaymentResponse;

public interface DoPaymentsManager {
    public SimplePaymentResponse doPayments(SimplePaymentRequest payReq) throws Exception;
}
