package by.innowisegroup.action;

import by.innowisegroup.IO.Input;
import by.innowisegroup.model.Role;
import by.innowisegroup.model.User;
import by.innowisegroup.store.Store;

public interface Action {

    String name();
    boolean execute(Input input, Store memTracker);

    default void setRole(Input input, User user) {
        for (int i = 0; i <= 2; i++) {
            System.out.println(i + 1 + ". " + Role.values()[i].name());
        }
        int indexRole = input.askInt("Choose Role First Level or Super_User: ") - 1;
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
    }
}
