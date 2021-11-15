package stringaddcalculator;

import java.util.Arrays;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (input == null || input.equals("")) {
            return 0;
        }
        return getSum(input);
    }

    private static int getSum(String input) {

        String replaceCharacter = getReplaceCharacter(input);

        StringProcessor stringProcessor = new StringProcessor(input, replaceCharacter);

        return stringProcessor
                .getStrings()
                .stream()
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static String getReplaceCharacter(String input) {
        if (input.contains(",")) {
            return ",";
        }
        if (input.contains(";")) {
            return ";";
        }
        return "";
    }
}
