package stringaddcalculator;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SomethingTest {

    /**
     * //;\n1;2;3
     * \/\/(.)\\n(.*)
     */

    @Test
    void regExpTest() {
        String targetText = "//;\\n1;2;3";
        String regex = "\\/\\/(.)\\\\n(.*)";
//        String targetText = "1;2;3";
        Matcher m = Pattern.compile(regex).matcher(targetText);
//        out.println(m.find());
        String customDelimiter = "";
        String[] tokens = null;
        if (m.find()) {
            customDelimiter = m.group(1);
            tokens = m.group(2).split(customDelimiter);
        }
    }
}
