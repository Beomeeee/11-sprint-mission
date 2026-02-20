package com.sprint.mission.discodeit.service;

import com.sprint.mission.discodeit.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    // CRUD 인터페이스 선언
    User create(String userName, String email, String password);
    User read(UUID id);
    List<User> readAll();
    User update(UUID id, String userName, String email, String password);
    void delete(UUID id);
}
