package by.innowisegroup.action;

import by.innowisegroup.IO.Input;
import by.innowisegroup.store.Store;

public class ExitAction implements Action {
    @Override
    public String name() {
        return "=== Exit ===";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        String condition = input.askStr("Exit. Enter Yes or No");
        if(condition.equals("Yes")){
            memTracker.save();
            return false;
        }
            return true;
    }
}
