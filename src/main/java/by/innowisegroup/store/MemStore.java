package by.innowisegroup.store;

import by.innowisegroup.IO.FileInput;
import by.innowisegroup.IO.FileOutput;
import by.innowisegroup.model.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MemStore implements Store {

    private final List<User> users = new ArrayList<>();
    private Integer id;

    @Override
    public void init() {
        if(new File("users.bin").isFile()) {
            FileOutput.readFile("users.bin", users);
            id = users.size();
        }
    }

    @Override
    public void save() {
        FileInput.writeFile("users.bin",users);
    }

    @Override
    public User add(User user) {
        if(user != null){
            this.users.add(user);
            System.out.println("Size array = " + this.users.size());
            return user;
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return users;
    }
}
