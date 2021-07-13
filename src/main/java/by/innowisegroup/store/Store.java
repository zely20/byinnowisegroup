package by.innowisegroup.store;

import by.innowisegroup.model.User;

import java.util.List;

public interface Store {

    User add(User user);
    boolean replace(Integer id, User user);
    boolean delete(Integer id);
    List<User> findAll();
    List<User> findByName(String key);
    User findById(Integer id);
}
