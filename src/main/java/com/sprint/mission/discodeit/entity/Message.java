package com.sprint.mission.discodeit.entity;

import java.util.UUID;

public class Message {

    // 공통
    private UUID id;
    private Long createdAt;
    private Long updatedAt;

    // Message 고유
    private String content;
    private UUID senderId;  // 메시지를 보낸 사람
    private UUID channelId; // 메시지를 보낸 채널

    // 생성자
    public Message(String content, UUID senderId, UUID channelId) {
        this.id = UUID.randomUUID();
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = null;

        this.content = content;
        this.senderId = senderId;
        this.channelId = channelId;
    }

    public UUID getId() {
        return id;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public String getContent() {
        return content;
    }

    public UUID getSenderId() {
        return senderId;
    }

    public UUID getChannelId() {
        return channelId;
    }

    public void update(String content) {
        this.content = content;
        this.updatedAt = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", content='" + content + '\'' +
                ", senderId=" + senderId +
                ", channelId=" + channelId +
                '}';
    }
}
