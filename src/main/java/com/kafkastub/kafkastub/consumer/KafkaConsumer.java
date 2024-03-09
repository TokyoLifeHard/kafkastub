package com.kafkastub.kafkastub.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    private static Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    private KafkaTemplate<String,String> kafkaTemplate;


    public KafkaConsumer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    @KafkaListener(topics = {"in"})
    public void read(String data){
        kafkaTemplate.send("out",data);
        LOGGER.info(String.format("Send message %s to in",data));
    }
}
