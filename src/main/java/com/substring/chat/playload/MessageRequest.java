package com.substring.chat.playload;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageRequest {

    private String content;
    private String sender;
    private String roomId;
    private LocalDateTime timeStamp;

    public MessageRequest(String sender, String content) {
        this.sender = sender;
        this.content = content;
        this.timeStamp = LocalDateTime.now() ;
    }
}
