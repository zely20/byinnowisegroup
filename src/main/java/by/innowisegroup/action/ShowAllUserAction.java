package by.innowisegroup.action;

import by.innowisegroup.IO.Input;
import by.innowisegroup.model.User;
import by.innowisegroup.store.Store;

public class ShowAllUserAction implements Action{
    @Override
    public String name() {
        return "=== Show All Users ===";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        memTracker.findAll().forEach(System.out::println);
        return true;
    }
}
