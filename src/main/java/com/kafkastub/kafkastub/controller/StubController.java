package com.kafkastub.kafkastub.controller;

import com.kafkastub.kafkastub.message.Message;
import com.kafkastub.kafkastub.service.ReaderWriterService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka_stub")
public class StubController {

    private ReaderWriterService rwService;

    public StubController(ReaderWriterService rwService) {
        this.rwService = rwService;
    }

    @PostMapping("/send")
    public void sendMessage(@RequestBody Message message){
        rwService.readWrite(message);
    }
}
