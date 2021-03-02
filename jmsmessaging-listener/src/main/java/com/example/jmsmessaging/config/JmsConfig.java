package com.example.jmsmessaging.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
@EnableScheduling
@EnableAsync
@Configuration
public class JmsConfig {
    public static final String MY_QUEUE="hello word";
    public static final String MY_REPLAY_QUEUE="replay to me";
    @Bean
    public MessageConverter messageConverter(){
        MappingJackson2MessageConverter converter=
                new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
}
