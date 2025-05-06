package com.substring.chat.controllers;

import com.substring.chat.entity.Message;
import com.substring.chat.entity.Room;
import com.substring.chat.repositories.RoomRepository;
import com.substring.chat.playload.MessageRequest;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@CrossOrigin("http://localhost:5173")
public class ChatController {

    private RoomRepository roomRepository;

    public ChatController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    //for sending and recived messages
    @MessageMapping("/sendMessage/{roomId}")// /chat/sendMessage/roomIs
    @SendTo("/topic/room/{roomId}")//suscribe
    public Message sendMessage(@DestinationVariable String roomId,
                               @RequestBody MessageRequest request){
        Room room = roomRepository.findByRoomId(request.getRoomId());

        Message message = new Message();
        message.setContent(request.getContent());
        message.setSender(request.getSender());
        message.setTimeStamp(LocalDateTime.now());
        if (room != null) {
            room.getMessages().add(message);
            roomRepository.save(room);
        } else {
            throw new RuntimeException("room not found !!");
        }

        return message;

    }

    // Para manejar el evento de "escribiendo..."
    @MessageMapping("/typing/{roomId}")
    @SendTo("/topic/room/{roomId}/typing")
    public String handleTyping(@DestinationVariable String roomId, @RequestBody String sender) {
        return sender; // Enviar el nombre del usuario que está escribiendo
    }


}
