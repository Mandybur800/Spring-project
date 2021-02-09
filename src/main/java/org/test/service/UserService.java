package org.test.service;

import java.util.List;
import org.test.model.User;

public interface UserService {
    void add(User user);

    List<User> listUsers();
}
