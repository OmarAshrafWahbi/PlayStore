package com.customer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CustomerListener {
    @KafkaListener(topics = "Customer", groupId = "customer")
    void listener(Map<String, Object> data) {
        System.out.println(data);
    }
}
