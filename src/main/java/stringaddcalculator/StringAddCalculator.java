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

        StringProcessor stringProcessor = new StringProcessor(input);

        return stringProcessor
                .getStrings()
                .stream()
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
