package stringaddcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessor {

    private List<String> strings;

    public StringProcessor(String input) {

        if (input.startsWith("//")) {
            String regex = "\\/\\/(.)\\n(.*)";
            Matcher m = Pattern.compile(regex).matcher(input);
            String customDelimiter = "";
            if (m.find()) {
                customDelimiter = m.group(1);
                strings = Arrays.asList(m.group(2).split(customDelimiter));
            }
            return;
        }

        validateString(input);
        strings = Arrays.asList(input.split("[,;]"));
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
