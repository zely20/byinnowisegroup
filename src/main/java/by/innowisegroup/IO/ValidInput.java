package by.innowisegroup.IO;

public class ValidInput implements Input {

    private final Input input;

    public ValidInput(Input input) {
        this.input = input;
    }

    @Override
    public String askStr(String question) {
        return input.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = input.askInt(question);
                invalid = false;
            } catch (IllegalStateException moe) {
                System.out.println("Please select validate data again.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        } while (invalid);
        return value;
    }

    @Override
    public int askInt(String question, int max) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = input.askInt(question, max);
                invalid = false;
            } catch (IllegalStateException moe) {
                System.out.println("Please enter validate data again.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        } while (invalid);
        return value;
    }

    public String askWithPattern(String question, String param) {
        boolean invalid = true;
        String value = "";
        do {
            try {
                value = input.askWithPattern(question, param);
                invalid = false;
            } catch (IllegalStateException moe) {
                System.out.println("Please enter validate data again.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        } while (invalid);
        return value;
    }
}
