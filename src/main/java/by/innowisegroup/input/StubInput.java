package by.innowisegroup.input;

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
        return Integer.valueOf(answers[position++]);
    }

    @Override
    public int askInt(String question, int max) {
        return Integer.valueOf(answers[position++]);
    }

    @Override
    public String askWithPattern(String question, String param) {
        return answers[position++];
    }
}
