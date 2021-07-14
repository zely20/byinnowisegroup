package by.innowisegroup.input;

import by.innowisegroup.input.Input;

public class StubInput implements Input {

    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String askStr(String question) {
        return answers[position++];
    }

    @Override
    public int askInt(String question) {
        return 0;
    }

    @Override
    public int askInt(String question, int max) {
        return 0;
    }

    @Override
    public String askWithPattern(String question) {
        return answers[position++];
    }
}
