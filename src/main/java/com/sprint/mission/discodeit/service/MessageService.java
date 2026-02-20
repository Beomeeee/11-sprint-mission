package com.sprint.mission.discodeit.service;

import com.sprint.mission.discodeit.entity.Message;

import java.util.List;
import java.util.UUID;

public interface MessageService {
    // CRUD 인터페이스 선언
    Message create(String content, UUID senderId, UUID channelId);
    Message read(UUID id);
    List<Message> readAll();
    Message update(UUID id, String content);
    void delete(UUID id);
}
