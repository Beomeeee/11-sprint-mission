package com.sprint.mission.discodeit.service.jcf;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.service.ChannelService;

import java.util.*;

public class JCFChannelService implements ChannelService {
    private final Map<UUID, Channel> data;

    public JCFChannelService() {
        this.data = new HashMap<>();
    }

    @Override
    public Channel create(String channelName, String description) {
        Channel newChannel = new Channel(channelName, description);
        data.put(newChannel.getId(), newChannel);
        return newChannel;
    }

    @Override
    public Channel read(UUID id) {
        return data.get(id);
    }

    @Override
    public List<Channel> readAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public Channel update(UUID id, String channelName, String description) {
        Channel channel = data.get(id);
        if (channel != null) {
            channel.update(channelName, description);
            return channel;
        }
        return null;
    }

    @Override
    public void delete(UUID id) {
        data.remove(id);
    }
}
