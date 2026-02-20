package com.sprint.mission.discodeit.entity;

import java.util.UUID;

public class User {
    // 공통
    private UUID id;
    private Long createdAt;
    private Long updatedAt;

    // User 고유
    private String userName;
    private String email;
    private String password;

    // 생성자
    public User(String userName, String email, String password) {

        // id, createdAt 초기화
        this.id = UUID.randomUUID();
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = null;

        this.userName = userName;
        this.email = email;
        this.password = password;
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

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void update(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.updatedAt = System.currentTimeMillis();
    }
}
