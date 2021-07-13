package by.innowisegroup.action;

import by.innowisegroup.input.Input;
import by.innowisegroup.model.User;
import by.innowisegroup.store.Store;

public class CreateUserAction implements Action {

    @Override
    public String name() {
        return "=== Create a new User ====";
    }

    @Override
    public boolean execute(Input input, Store memStore) {
        String name = input.askStr("Enter name: ");
        String surname = input.askStr("Enter surname: ");
        String email = input.askStr("Enter email: ");
        User user = new User(name, surname, email);
        for (int i = 0; i < 3; i++){
            String phone = input.askStr("Enter phone " + (i + 1)+": ");
            if(phone != null || phone != ""){
                user.setPhone(phone);
            }
        }
        return true;
    }
}
