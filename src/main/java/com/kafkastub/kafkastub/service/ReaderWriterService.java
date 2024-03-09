package com.kafkastub.kafkastub.service;

import com.kafkastub.kafkastub.consumer.KafkaConsumer;
import com.kafkastub.kafkastub.message.Message;
import com.kafkastub.kafkastub.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executor;

@Service
public class ReaderWriterService {

    private static Logger LOGGER = LoggerFactory.getLogger(ReaderWriterService.class);

    private KafkaProducer kafkaProducer;

    @Autowired
    @Qualifier("readPoolTaskExecutor")
    Executor executor;

    public ReaderWriterService(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    public void readWrite(Message message) {
        LOGGER.info(String.format("Send message %s from in to out",message));
        executor.execute(()->kafkaProducer.send(message.toString()));
    }
}
