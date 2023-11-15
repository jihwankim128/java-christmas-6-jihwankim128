package christmas.utility;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Utility {
    public static List<String> splitUtility(String source, String regx) {
        return Arrays.stream(source.split(regx)).map(String::trim).collect(Collectors.toList());
    }

    public static String numberFormatter(int number) {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.KOREA);
        return formatter.format(number);
    }
}
