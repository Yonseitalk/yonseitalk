package com.example.yonseitalk.repository;

import com.example.yonseitalk.domain.Message;


import java.util.List;
import java.util.Optional;

public interface MessageRepository {

    Optional<Message> findById(Long id);

    Message save(Message message);

    List<Message> findByChatroomId(Long chatroom_id);

}
