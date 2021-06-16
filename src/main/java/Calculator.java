import java.util.Arrays;

public class Calculator {

    private static final String SEPARATOR = ",";

    public static int add(String input) {
        if(input==null || input.isEmpty()) {
            return 0;
        }
        String[] numbers = input.split(SEPARATOR);
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}