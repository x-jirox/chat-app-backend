package com.substring.chat.repositories;

import com.substring.chat.entity.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<Room, String> {

    //get room using id
    Room findByRoomId(String roomId);
}
