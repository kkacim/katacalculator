import java.util.Arrays;

public class Calculator {

    private static final String SEPARATOR_REGEX = "[,\n]";

    public static int add(String input) {
        if(input==null || input.isEmpty()) {
            return 0;
        }
        String[] numbers = input.split(SEPARATOR_REGEX);
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}