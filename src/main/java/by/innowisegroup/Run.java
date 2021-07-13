package by.innowisegroup;

import by.innowisegroup.action.Action;
import by.innowisegroup.action.CreateUserAction;
import by.innowisegroup.input.ConsoleInput;
import by.innowisegroup.input.Input;
import by.innowisegroup.store.MemStore;
import by.innowisegroup.store.Store;

import java.util.ArrayList;
import java.util.List;

public class Run {

    public void init(Input input, Store memTracker, List<Action> actions) {
        boolean run = true;
        while (run) {
            actions.forEach(action -> System.out.println(action.name()));
            int select = input.askInt("Select: ");
            Action action = actions.get(select);
            run = action.execute(input, memTracker);
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        List<Action> actions = new ArrayList<>();
        actions.add(new CreateUserAction());
            Store tracker = new MemStore();
            new Run().init(input, tracker, actions);
    }
}
