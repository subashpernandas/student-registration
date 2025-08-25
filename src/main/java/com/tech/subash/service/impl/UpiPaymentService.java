package com.tech.subash.service.impl;

import com.tech.subash.dto.PaymentMode;
import com.tech.subash.service.PaymentService;
import org.springframework.stereotype.Service;

@Service("upi")
public class UpiPaymentService implements PaymentService {
    @Override
    public String payment(PaymentMode paymentMode) {
        return paymentMode.getPaymentMode() + " "+ paymentMode.getAmount();

    }
}
