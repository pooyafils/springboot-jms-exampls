package com.example.kafkaproducer.controller;

import com.example.kafkaproducer.model.User;
import org.apache.kafka.common.KafkaException;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafkaproducer")
public class UserController {
    @Autowired
KafkaTemplate<String, User> kafkaTemplate;
    private final String TOPIC="Kafka_Example";
    @GetMapping("/{message}")
    public String sendMessage(@PathVariable("message") final String message){
        kafkaTemplate.send(TOPIC,new User(1,"java","kafka"));
        return "message has been send";
    }
}
