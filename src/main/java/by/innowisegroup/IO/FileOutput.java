package by.innowisegroup.IO;

import by.innowisegroup.model.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class FileOutput {

    public static List<User> readFile(String nameFile, List<User> users) {
        try(ObjectInputStream read = new ObjectInputStream(new FileInputStream(nameFile))){
            if(read.available() > 0) {
                int count = read.readInt();
                for (int i = 0; i < count; i++) {
                    users.add((User) read.readObject());
                }
            }
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return users;
    }
}
