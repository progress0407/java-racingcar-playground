package stringaddcalculator;

import java.util.Arrays;
import java.util.List;

public class StringProcessor {

    private List<String> strings;

    public StringProcessor(String input, String replaceCharacter) {
        validateString(input);
        strings = Arrays.asList(input.split(replaceCharacter));
    }

    public List<String> getStrings() {
        return strings;
    }

    private void validateString(String input) {
        for (char c : input.toCharArray()) {
            if (c == ',' || c == ';') {
                continue;
            }
            if (c < '1' || c > '9') {
                throw new RuntimeException("1에서 9 사이의 숫자이어야 합니다.");
            }
        }
    }
}
