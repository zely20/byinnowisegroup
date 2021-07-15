package by.innowisegroup.input;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String askStr(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    @Override
    public int askInt(String question) {
        return Integer.valueOf(askStr(question));
    }

    @Override
    public int askInt(String question, int max) {
        int select = askInt(question);
        if (select < 1 || select >= max + 1) {
            throw new IllegalStateException(String.format("Out of about %s > [0, %s]", select, max));
        }
        return select;
    }

    @Override
    public String askWithPattern(String question, String param) {
        String result = askStr(question);
        Pattern pattern = Pattern.compile(param);
        Matcher matcher = pattern.matcher(result);
        if(!matcher.matches()) {
            throw new IllegalStateException(String.format("Please check data with pattern"));
        }
        return result;
    }
}
