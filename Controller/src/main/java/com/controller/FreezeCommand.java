package com.controller;

import org.springframework.kafka.core.KafkaTemplate;

import java.util.Map;

public class FreezeCommand implements CommandExecutor {
    private KafkaTemplate<String, Map<String, Object>> kafkaTemplate;

    public FreezeCommand(KafkaTemplate<String, Map<String, Object>> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void execute(Map<String, Object> request) {
        kafkaTemplate.send((String) request.get("AppName"), request);
    }
}
