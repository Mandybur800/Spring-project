package org.test.dao;

import java.util.List;
import org.test.model.User;

public interface UserDao {
    void add(User user);

    List<User> listUsers();
}
