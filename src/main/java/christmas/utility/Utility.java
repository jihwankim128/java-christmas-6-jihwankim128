package christmas.utility;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utility {
    public static List<String> splitUtility(String source, String regx) {
        return Arrays.stream(source.split(regx)).map(String::trim).collect(Collectors.toList());
    }
}
