package com.product;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/Product")
public class ProductController {
    private KafkaTemplate<String, Map<String, Object>> kafkaTemplate;

    @PostMapping("/hello")
    public String hello(){
        return "Hello";
    }

    public ProductController(KafkaTemplate<String, Map<String, Object>> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("testConn")
    public void publish(@RequestBody Map<String, Object> request){
        kafkaTemplate.send((String) request.get("AppName"), request);
    }
}
