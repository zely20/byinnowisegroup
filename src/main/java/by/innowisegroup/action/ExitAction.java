package by.innowisegroup.action;

import by.innowisegroup.input.Input;
import by.innowisegroup.store.Store;

public class ExitAction implements Action {
    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        return false;
    }
}
