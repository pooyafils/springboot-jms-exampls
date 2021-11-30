package com.example.kafkaconsumer.listener;

import model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics ="Kafka_Example",groupId = "group_id")
    public void consumer(String message){
        System.out.println("Consumer message "+message);
    }
    @KafkaListener(topics ="Kafka_Example_json",groupId = "group_json",  containerFactory = "userKafkaListenerFactory")
    public void consumer(User user){
        System.out.println("other message "+user);
    }
}
