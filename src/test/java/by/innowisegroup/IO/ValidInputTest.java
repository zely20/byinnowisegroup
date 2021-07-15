package by.innowisegroup.IO;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ValidInputTest {

    @Test
    public void askEmailValid() {
        ValidInput validInput = new ValidInput(new StubInput(new String[]{"zely1984@gmail.com"}));
        String result = validInput.askWithPattern("Enter email: ", "\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}");
        assertThat(result,
                is("zely1984@gmail.com"));
    }

    @Test
    public void askPhoneValid() {
        ValidInput validInput = new ValidInput(new StubInput(new String[]{"zely1984@gmail.com"}));
        String result = validInput.askWithPattern("Enter phone: ", "");
        assertThat(result,
                is("zely1984@gmail.com"));
    }
}
