package com.substring.chat.chat_app_backend.entity;

import lombok.Data;

import java.time.LocalDateTime;


@Data

public class Message {
    private String sender;
    private String content;
    private LocalDateTime timeStamp;

    public  Message(String sender, String content) {
        this.sender=sender;
        this.content=content;
        this.timeStamp=LocalDateTime.now();

    }
}
