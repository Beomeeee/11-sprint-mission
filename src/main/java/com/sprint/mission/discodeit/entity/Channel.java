package com.sprint.mission.discodeit.entity;

import java.util.UUID;

public class Channel {
    // 공통
    private UUID id;
    private Long createdAt;
    private Long updatedAt;

    // Channel 고유
    private String channelName;
    private String description;

    // 생성자
    public Channel(String channelName, String description) {
        this.id = UUID.randomUUID();
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = null;

        this.channelName = channelName;
        this.description = description;
    }

    // Getter
    public UUID getId() {
        return id;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public String getChannelName() {
        return channelName;
    }

    public String getDescription() {
        return description;
    }

    public void update(String channelName, String description) {
        this.channelName = channelName;
        this.description = description;
        this.updatedAt = System.currentTimeMillis();
    }

}
