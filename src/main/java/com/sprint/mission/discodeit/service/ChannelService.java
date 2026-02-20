package com.sprint.mission.discodeit.service;

import com.sprint.mission.discodeit.entity.Channel;

import java.util.List;
import java.util.UUID;

public interface ChannelService {
    // CRUD 인터페이스 선언
    Channel create(String channelName, String description);
    Channel read(UUID id);
    List<Channel> readAll();
    Channel update(UUID id, String channelName, String description);
    void delete(UUID id);
}
