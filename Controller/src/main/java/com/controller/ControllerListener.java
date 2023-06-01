package com.controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ControllerListener {
    @KafkaListener(topics = "ServiceX", groupId = "serviceX")
    void listener(Map<String, Object> data) {
        System.out.println(data);
    }
}
