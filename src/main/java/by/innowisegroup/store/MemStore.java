package by.innowisegroup.store;

import by.innowisegroup.IO.FileInput;
import by.innowisegroup.IO.FileOutput;
import by.innowisegroup.model.User;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MemStore implements Store {

    private final List<User> users = new ArrayList<>();
    private Integer id = 0;

    @Override
    public void init() {
        if (new File("users.bin").isFile()) {
            FileOutput.readFile("users.bin", users);
            id = users.size();
        }
    }

    @Override
    public void save() {
        FileInput.writeFile("users.bin", users);
    }

    @Override
    public User add(User user) {
        if (user != null) {
            user.setId(++id);
            this.users.add(user);
            return user;
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public boolean delete(Integer id) {
        User user = findById(id);
        if (user != null) {
            users.remove(user);
            return true;
        }
        return false;
    }

    @Override
    public User findById(Integer id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
}
