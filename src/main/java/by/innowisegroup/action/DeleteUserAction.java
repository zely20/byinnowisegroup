package by.innowisegroup.action;

import by.innowisegroup.IO.Input;
import by.innowisegroup.store.Store;

public class DeleteUserAction implements Action {
    @Override
    public String name() {
        return "=== Delete User ===";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        Integer id = input.askInt("For delete item please enter ID ");
        if (memTracker.delete(id)) {
            System.out.println("User deleted");
        } else {
            System.out.println("User was not delete");
        }
        return true;
    }
}
