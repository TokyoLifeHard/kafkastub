package com.kafkastub.kafkastub.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;

@Component
public class KafkaProducer {

    private static Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    private KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    @Qualifier("writePoolTaskExecutor")
    private Executor executor;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String message){
        LOGGER.info(String.format("Send message %s",message));
        executor.execute(()->this.kafkaTemplate.send("in",message));
    }
}
