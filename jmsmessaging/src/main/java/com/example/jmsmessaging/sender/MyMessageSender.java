package com.example.jmsmessaging.sender;

import com.example.jmsmessaging.config.JmsConfig;
import com.example.jmsmessaging.model.MyMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.UUID;
@Component
public class MyMessageSender {
    private final JmsTemplate jmsTemplate;
    private final ObjectMapper objectMapper;

    public MyMessageSender(JmsTemplate jmsTemplate, ObjectMapper objectMapper) {
        this.jmsTemplate = jmsTemplate;
        this.objectMapper = objectMapper;
    }
     @Scheduled(fixedRate = 5000)
    public void sendMessage(){
         System.out.println("i am sending message");

        MyMessage myMessage=MyMessage.builder()
                .id(UUID.randomUUID())
                .myMessage("Hello")
                .build();
        System.out.println("    Message send");
        jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE,myMessage);

    }
/*
    @Scheduled(fixedRate = 2000)
    public void sendAndReceive() throws JMSException{
        MyMessage myMessage=MyMessage.builder()
                .id(UUID.randomUUID())
                .myMessage("Hello replay and answer")
                .build();
        Message receviedMsg=jmsTemplate.sendAndReceive(JmsConfig.MY_REPLAY_QUEUE, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                    Message myHelloMessage=null;
                    try {
                        myHelloMessage=session.createTextMessage(objectMapper.writeValueAsString(myMessage));
                    myHelloMessage.setStringProperty("_type","com.example.jmsmessaging.model.MyMessage");
                   System.out.println("sending my hello message");
                   return myHelloMessage;
                    }catch (JsonProcessingException e){
                        throw new JMSException("boom");

                    }
            }
        });
System.out.println(receviedMsg.getBody(String.class));
    }*/

}
