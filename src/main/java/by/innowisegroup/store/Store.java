package by.innowisegroup.store;

import by.innowisegroup.model.User;

import java.util.List;

public interface Store {

    User add(User user);
    List<User> findAll();
    void init();
    void save();
    boolean delete(Integer id);
    Integer indexOf(Integer id);
    User findById(Integer id);
}
