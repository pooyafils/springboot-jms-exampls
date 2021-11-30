package com.example.kafkaconsumer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics ="Kafka_Example",groupId = "group_id")
    public void consumer(String message){
        System.out.println("Consumer message "+message);
    }
}
