package com.tech.subash.controller.dynamic.swithching;

import com.tech.subash.dto.PaymentMode;
import com.tech.subash.service.CriteriaService;
import com.tech.subash.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
@Slf4j
public class PaymentController {


   /* @Autowired
    @Qualifier("paypal")
        OR
    @Resource(name ="paypal")
    private PaymentService upiPaymentService;*/

    @Autowired
    private Map<String, PaymentService> paymentServiceMap = new HashMap<>();

   /*
    private PaymentService upiPaymentService;

    private PaymentService paypalPaymentService;

    private PaymentService stripePaymentService;

    @Autowired
    public PaymentController(PaymentService upiPaymentService,
                             PaymentService paypalPaymentService ,PaymentService stripePaymentService){
        this.upiPaymentService = upiPaymentService;
        this.paypalPaymentService = paypalPaymentService;
        this.stripePaymentService = stripePaymentService;
    }*/



   /* @PostMapping("/post")
    public String paymentMode(@RequestBody PaymentMode paymentMode){
       return switch (paymentMode.getPaymentMode().toUpperCase()){

            case "PAYPAL" ->  paypalPaymentService.payment(paymentMode.getPaymentMode());
            case "STRIPE" -> stripePaymentService.payment(paymentMode.getPaymentMode());
            case "UPI" -> upiPaymentService.payment(paymentMode.getPaymentMode());
           default -> throw new IllegalStateException("Unexpected value: " + paymentMode.getPaymentMode().toLowerCase());
       };
    }*/

    @Autowired
    private CriteriaService criteriaService;

    @PostMapping("/postV2")
    public String paymentMode(@RequestBody PaymentMode paymentMode) {
        log.info("Async Hashcode "+ criteriaService.hashCode());
        PaymentService paymentService = paymentServiceMap.get(paymentMode.getPaymentMode());
        if (paymentServiceMap == null) {
            throw new IllegalStateException("Unexpected value: " + paymentMode.getPaymentMode().toLowerCase());
        } else {
            return paymentService.payment(paymentMode);
        }
    }
}
