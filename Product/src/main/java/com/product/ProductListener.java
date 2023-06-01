package com.product;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ProductListener {
    @KafkaListener(topics = "Product", groupId = "product")
    void listener(Map<String, Object> data) {
        System.out.println(data);
    }
}
