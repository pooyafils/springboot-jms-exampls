package com.example.kafkaproducer.controller;

import com.example.kafkaproducer.model.User;
import com.example.kafkaproducer.repository.UserRepository;
import org.apache.kafka.common.KafkaException;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafkaproducer")
public class UserController {
    @Autowired
KafkaTemplate<String, User> kafkaTemplate;
    @Autowired
    UserRepository userRepository;
    private final String TOPIC="Kafka_Example";
    @GetMapping
    public String sendMessage(@RequestBody User user){
        userRepository.save(user);
        kafkaTemplate.send(TOPIC,user);
        return "message has been send";
    }
}
