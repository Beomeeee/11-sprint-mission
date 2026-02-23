package com.sprint.mission.discodeit.service.jcf;

import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.service.UserService;
import java.util.*;

public class JCFUserService implements UserService {
    private final Map<UUID, User> data;

    public JCFUserService() {
        this.data = new HashMap<>();
    }
    @Override
    public User create(String  userName, String email, String password) {
        User newUser = new User(userName, email, password);
        data.put(newUser.getId(), newUser);
        return newUser;
    }

    @Override
    public User read(UUID id) {
        return data.get(id);
    }

    @Override
    public List<User> readAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public User update(UUID id, String userName, String email, String password) {
        User user = data.get(id);
        if (user != null) {
            user.update(userName, email, password);
            return user;
        }
        return null;
    }

    @Override
    public void delete(UUID id) {
        data.remove(id);
    }
}

