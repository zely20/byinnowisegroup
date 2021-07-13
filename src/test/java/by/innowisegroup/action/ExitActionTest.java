package by.innowisegroup.action;

import by.innowisegroup.input.StubInput;
import by.innowisegroup.store.MemStore;
import org.junit.Assert;
import org.junit.Test;

public class ExitActionTest {

    @Test
    public void executeExitYes() {
        Action action = new ExitAction();
        boolean result = action.execute(new StubInput(new String[]{"Yes"}), new MemStore());
        Assert.assertFalse(result);
    }

    @Test
    public void executeExitNo() {
        Action action = new ExitAction();
        boolean result = action.execute(new StubInput(new String[]{"No"}), new MemStore());
        Assert.assertTrue(result);
    }
}
