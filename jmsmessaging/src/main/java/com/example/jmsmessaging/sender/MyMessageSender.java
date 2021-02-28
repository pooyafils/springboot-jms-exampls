package com.example.jmsmessaging.sender;

import com.example.jmsmessaging.config.JmsConfig;
import com.example.jmsmessaging.model.MyMessage;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyMessageSender {
    private final JmsTemplate jmsTemplate;

    public MyMessageSender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Scheduled
    public void sendMessage(){
        MyMessage myMessage=MyMessage.builder()
                .id(1)
                .myMessage("Hello")
                .build();
    jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE,myMessage);
        System.out.println("Message send");

    }
}
