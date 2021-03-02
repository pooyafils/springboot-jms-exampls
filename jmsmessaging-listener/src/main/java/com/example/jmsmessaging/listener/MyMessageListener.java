package com.example.jmsmessaging.listener;

import com.example.jmsmessaging.config.JmsConfig;
import com.example.jmsmessaging.model.MyMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import java.util.UUID;

@Component
public class MyMessageListener {
    private final JmsTemplate jmsTemplate;

    public MyMessageListener(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

   @JmsListener(destination = JmsConfig.MY_QUEUE)
       public void listener(@Payload MyMessage myMessage, @Headers MessageHeaders messageHeaders
            , Message meaage){
       System.out.println("i got the message");
        System.out.println(myMessage);


            }
   /* @JmsListener(destination = JmsConfig.MY_REPLAY_QUEUE)
public void listenForMessageAndReplay(@Payload MyMessage myMessage,
                                      @Headers MessageHeaders headers,
                                      Message message) throws JMSException{
        MyMessage myMessageListener=MyMessage.builder()
                .id(UUID.randomUUID())
                .myMessage("Hello replay and answer from listener")
                .build();
        jmsTemplate.convertAndSend(message.getJMSReplyTo(),myMessageListener);
    }*/
}
