package by.innowisegroup.action;

import by.innowisegroup.input.Input;
import by.innowisegroup.model.Role;
import by.innowisegroup.model.User;
import by.innowisegroup.store.Store;


public class CreateUserAction implements Action {

    private static final String EMAIL_PATTERN = "\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}";
    private static final String PHONE_PATTERN = "\\[375]{3}\\s\\d{2}\\s\\d{7}";

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
        int quantityNumberPhone = input.askInt("Please select the number of telephone numbers that you want to save from 1 to 3");
        for (int i = 0; i < quantityNumberPhone; i++){
            String phone = input.askStr("Enter phone " + (i + 1)+": ");
            if(phone != null && phone != ""){
                user.setPhone(phone);
            }
        }
        System.out.println("Please choose ROLE");
        for (int i = 0; i <= 2; i++) {
            System.out.println(i + 1 + ". " + Role.values()[i].name());
        }
            int indexRole = input.askInt("Choose Role First Level: ") - 1;
        if(Role.values()[indexRole].equals(Role.SUPER_ADMIN)){
            user.setRole(Role.SUPER_ADMIN);
        } else {
            user.setRole(Role.values()[indexRole]);
            for (int i = 3; i < 5; i++) {
                System.out.println(i - 2 + ". " + Role.values()[i].name());
            }
            int indexRoleTwo = input.askInt("Choose Role Second Level: ") + 2;
            user.setRole(Role.values()[indexRoleTwo]);
        }
        memStore.add(user);
        System.out.println(user);
        return true;
    }
}
