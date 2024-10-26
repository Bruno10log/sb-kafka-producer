package com.bruno10log.sb_kafka_producer.producer;

import com.bruno10log.sb_kafka_producer.dto.PaymentDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentRequestProducer {

    @Value("${topics.payment.request.topic}")
    private String topicPaymentRequest;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public String sendMessage(PaymentDto payment) throws JsonProcessingException {
        String content = objectMapper.writeValueAsString(payment);
        kafkaTemplate.send(topicPaymentRequest, content);
        return "Payment sent to processing";
    }

}
