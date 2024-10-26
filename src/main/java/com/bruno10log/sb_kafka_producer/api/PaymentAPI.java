package com.bruno10log.sb_kafka_producer.api;

import com.bruno10log.sb_kafka_producer.dto.PaymentDto;
import com.bruno10log.sb_kafka_producer.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentAPI {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public String pay(@RequestBody PaymentDto payment) {
        return paymentService.handlePayment(payment);
    }

}
