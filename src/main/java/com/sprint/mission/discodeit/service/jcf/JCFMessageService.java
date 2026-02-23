package com.sprint.mission.discodeit.service.jcf;

import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.service.MessageService;

import java.util.*;

public class JCFMessageService implements MessageService {
    private final Map<UUID, Message> data;

    public JCFMessageService() {
        this.data = new HashMap<>();
    }

    @Override
    public Message create(String content, UUID senderId, UUID channelId) {
        Message newMessage = new Message(content, senderId, channelId);
        data.put(newMessage.getId(), newMessage);
        return newMessage;
    }

    @Override
    public Message read(UUID id) {
        return data.get(id);
    }

    @Override
    public List<Message> readAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public Message update(UUID id, String content) {
        Message message = data.get(id);
        if (message != null) {
            message.update(content);
            return message;
        }
        return null;
    }

    @Override
    public void delete(UUID id) {
        data.remove(id);
    }
}