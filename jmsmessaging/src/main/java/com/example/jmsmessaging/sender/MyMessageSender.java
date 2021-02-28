package com.example.jmsmessaging.sender;

import com.example.jmsmessaging.config.JmsConfig;
import com.example.jmsmessaging.model.MyMessage;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MyMessageSender {
    private final JmsTemplate jmsTemplate;

    public MyMessageSender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Scheduled(fixedRate = 2000)
    public void sendMessage(){
         System.out.println("i am sending message");

        MyMessage myMessage=MyMessage.builder()
                .id(UUID.randomUUID())
                .myMessage("Hello")
                .build();
    jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE,myMessage);
        System.out.println("Message send");

    }

}
