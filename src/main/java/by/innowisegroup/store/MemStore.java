package by.innowisegroup.store;

import by.innowisegroup.model.User;

import java.util.ArrayList;
import java.util.List;

public class MemStore implements Store {

    private final List<User> users = new ArrayList<>();

    @Override
    public User add(User user) {
        if(user != null){
            this.users.add(user);
            return user;
        }
        return null;
    }

    @Override
    public boolean replace(Integer id, User user) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public List<User> findByName(String key) {
        return null;
    }

    @Override
    public User findById(Integer id) {
        return null;
    }
}
