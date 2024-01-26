package com.kafkastub.kafkastub.service;

import com.kafkastub.kafkastub.consumer.KafkaConsumer;
import com.kafkastub.kafkastub.message.Message;
import com.kafkastub.kafkastub.producer.KafkaProducer;
import org.springframework.stereotype.Service;

@Service
public class ReaderWriterService {

    private KafkaProducer kafkaProducer;
    private KafkaConsumer kafkaConsumer;

    public ReaderWriterService(KafkaProducer kafkaProducer, KafkaConsumer kafkaConsumer) {
        this.kafkaProducer = kafkaProducer;
        this.kafkaConsumer = kafkaConsumer;
    }

    public void readWrite(Message message) {
        kafkaProducer.send(message.toString());
        kafkaConsumer.read(message.toString());
    }
}
