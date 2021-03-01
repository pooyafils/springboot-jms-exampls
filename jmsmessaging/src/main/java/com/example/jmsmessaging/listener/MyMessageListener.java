package com.example.jmsmessaging.listener;

import com.example.jmsmessaging.config.JmsConfig;
import com.example.jmsmessaging.model.MyMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
public class MyMessageListener {

@JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listener(@Payload MyMessage myMessage, @Headers MessageHeaders messageHeaders
        , Message meaage){
    System.out.println("i got the message");
    System.out.println(myMessage);

        }
}
