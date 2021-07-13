package by.innowisegroup.action;

import by.innowisegroup.input.Input;
import by.innowisegroup.store.Store;

public interface Action {

    String name();

    boolean execute(Input input, Store memTracker);
}
