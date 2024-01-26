package com.kafkastub.kafkastub.message;

import java.util.UUID;

public class Message {
    private String uuid;
    private String data;

    public Message() {
        this.uuid = UUID.randomUUID().toString();
    }

    public Message(String data) {
        this.uuid = UUID.randomUUID().toString();
        this.data = data;
    }

    public String getUuid() {
        return uuid;
    }

    public String getData() {
        return data;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Message{" +
                "uuid='" + uuid + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
