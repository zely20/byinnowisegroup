package by.innowisegroup.IO;

import by.innowisegroup.model.User;

import java.io.*;
import java.util.List;

public class FileInput{

    public static void writeFile(String nameFile, List <User> data) {
        try(ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(nameFile, true))){
            write.writeInt(data.size());
            for(User user : data) {
                write.writeObject(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
