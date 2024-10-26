package com.bruno10log.sb_kafka_producer.service;

import com.bruno10log.sb_kafka_producer.dto.PaymentDto;
import com.bruno10log.sb_kafka_producer.producer.PaymentRequestProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaymentService {

    @Autowired
    private PaymentRequestProducer paymentRequestProducer;

    public String handlePayment(PaymentDto payment) {
        try {
            return paymentRequestProducer.sendMessage(payment);
        } catch (JsonProcessingException e) {
            return "Error when requesting a payment " + e.getMessage();
        }
    }
 }
