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
            id = this.users.get(users.size()-1).getId();
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
        int index = indexOf(id);
        if (index >= 0) {
            this.users.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public Integer indexOf(Integer id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public User findById(Integer id) {
        return this.users.get(indexOf(id));
    }
}
