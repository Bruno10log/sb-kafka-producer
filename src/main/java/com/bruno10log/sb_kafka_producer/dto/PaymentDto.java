package com.bruno10log.sb_kafka_producer.dto;

import java.math.BigDecimal;

public record PaymentDto(Integer number, String description, BigDecimal value) {
}
