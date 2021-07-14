package by.innowisegroup.input;

public interface Input {
    String askStr(String question);
    int askInt(String question);
    int askInt(String question, int max);
    String askWithPattern(String question, String param);
}
