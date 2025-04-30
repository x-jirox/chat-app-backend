package com.substring.chat.chat_app_backend.repositories;

import com.substring.chat.chat_app_backend.entity.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<Room, String> {

    //get room using id
    Room findByRoomId(String roomId);
}
