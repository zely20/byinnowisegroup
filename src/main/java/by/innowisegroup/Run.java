package by.innowisegroup;

import by.innowisegroup.action.Action;
import by.innowisegroup.action.CreateUserAction;
import by.innowisegroup.action.ExitAction;
import by.innowisegroup.action.ShowAllUserAction;
import by.innowisegroup.IO.ConsoleInput;
import by.innowisegroup.IO.Input;
import by.innowisegroup.IO.ValidInput;
import by.innowisegroup.store.MemStore;
import by.innowisegroup.store.Store;

import java.util.ArrayList;
import java.util.List;

public class Run {

    public void init(Input input, Store memTracker, List<Action> actions) {
        boolean run = true;
        while (run) {
            for(int i = 0; i < actions.size(); i++) {
                System.out.println(actions.get(i).name() + " for choose enter number " + (i+1));
            }
            int select = input.askInt("Select: ", 3);
            Action action = actions.get(select - 1);
            run = action.execute(input, memTracker);
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Input validate = new ValidInput(input);
        List<Action> actions = new ArrayList<>();
        actions.add(new CreateUserAction());
        actions.add(new ShowAllUserAction());
        actions.add(new ExitAction());
            Store tracker = new MemStore();
            tracker.init();
            new Run().init(validate, tracker, actions);
    }
}
