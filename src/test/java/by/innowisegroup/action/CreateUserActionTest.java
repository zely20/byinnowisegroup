package by.innowisegroup.action;

import by.innowisegroup.input.StubInput;
import by.innowisegroup.model.Role;
import by.innowisegroup.model.User;
import by.innowisegroup.store.MemStore;
import by.innowisegroup.store.Store;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CreateUserActionTest {

    @Test
    public void execute() {
        Action addUser = new CreateUserAction();
        Store store = new MemStore();
        User executed = new User("Ivan", "Ivanov", "ivan@mail.ru");
        executed.setPhone("375 29 1234578");
        executed.setRole(Role.SUPER_ADMIN);
        addUser.execute(new StubInput(new String[]{"Ivan", "Ivanov", "ivan@mail.ru", "1","375 29 1234578", "1"}), store);
        assertThat(store.findAll().get(0), is(executed));
    }
}