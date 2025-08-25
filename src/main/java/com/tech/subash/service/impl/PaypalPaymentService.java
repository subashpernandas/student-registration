package com.tech.subash.service.impl;

import com.tech.subash.dto.PaymentMode;
import com.tech.subash.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("paypal")
//@Profile(value = "uat")
public class PaypalPaymentService implements PaymentService {

    @Value("${payment.mode}")
    private String PAYMENT_MODE;

    @Override
    public String payment(PaymentMode paymentMode) {
        return paymentMode.getPaymentMode() + " "+ paymentMode.getAmount() + " "+PAYMENT_MODE;

    }
}
