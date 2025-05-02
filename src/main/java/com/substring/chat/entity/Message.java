package com.substring.chat.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
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
