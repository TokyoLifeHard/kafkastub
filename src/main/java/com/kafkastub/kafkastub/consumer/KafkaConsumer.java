package com.kafkastub.kafkastub.consumer;

import com.kafkastub.kafkastub.producer.KafkaProducer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    private KafkaTemplate<String,String> kafkaTemplate;


    public KafkaConsumer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    @KafkaListener(topics = {"in"})
    public void read(String data){
        kafkaTemplate.send("out",data);
    }
}
