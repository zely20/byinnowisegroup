package by.innowisegroup.action;

import by.innowisegroup.IO.Input;
import by.innowisegroup.model.Role;
import by.innowisegroup.model.User;
import by.innowisegroup.store.Store;


public class CreateUserAction implements Action {

    private static final String EMAIL_PATTERN = "\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}";
    private static final String PHONE_PATTERN = "375\\s\\d{2}\\s\\d{7}";

    @Override
    public String name() {
        return "=== Create a new User ====";
    }

    @Override
    public boolean execute(Input input, Store memStore) {
        String name = input.askStr("Enter name: ");
        String surname = input.askStr("Enter surname: ");
        String email = input.askWithPattern("Enter email: ", EMAIL_PATTERN);
        User user = new User(name, surname, email);
        int quantityNumberPhone = input.askInt("Please select the number of telephone numbers that you want to save from 1 to 3",3);
        for (int i = 0; i < quantityNumberPhone; i++){
            String phone = input.askWithPattern("Enter phone like 375 ** *******" + (i + 1)+": ", PHONE_PATTERN);
            if(phone != null && !phone.equals("")){
                user.setPhone(phone);
            }
        }
        System.out.println("Please choose ROLE");
        setRole(input, user);
        memStore.add(user);
        return true;
    }
}
