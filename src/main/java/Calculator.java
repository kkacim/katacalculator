import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Calculator {

    private static final String DEFAULT_SEPARATOR_REGEX = "[,\n]";

    public static int add(String input) {
        if(input==null || input.isEmpty()) {
            return 0;
        }

        String[] numbers = splitToNumbers(input);

        checkForNegativeNumbers(numbers);

        return getIntStreamFromArray(numbers).sum();
    }

    /**
     * Tokenize the input
     *
     * @param input The input
     * @return Numbers array
     */
    private static String[] splitToNumbers(String input) {
        // Custom Separator
        if(input.startsWith("//")) {
            return splitUsingCustomSeparator(input);
        }
        // Default Separators
        return splitUsingDefaultSeparators(input);
    }

    /**
     * Split the input using custom separator
     *
     * @param input The input "//[SEPARATOR]\n1[SEPARATOR]2"
     * @return The numbers
     */
    private static String[] splitUsingCustomSeparator(String input) {
        // Regex to capture the custom separator and numbers
        // Group 1: Custom separator
        // Group 2: Numbers
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        matcher.matches();
        return matcher.group(2).split(Pattern.quote(matcher.group(1)));
    }

    /**
     * Split the input using default separators
     *
     * @param input The input "1,2\n3"
     * @return The numbers
     */
    private static String[] splitUsingDefaultSeparators(String input) {
        return input.split(DEFAULT_SEPARATOR_REGEX);
    }

    /**
     * Transform String array to IntStream
     *
     * @param numbers String array
     * @return IntStream
     */
    private static IntStream getIntStreamFromArray(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(Integer::parseInt);
    }

    /**
     * Check that all numbers are positive. If negatives detected throw an exception
     * @param numbers Numbers array
     * @throws RuntimeException
     */
    private static void checkForNegativeNumbers(String[] numbers) throws RuntimeException{
        String negatives = getIntStreamFromArray(numbers)
                .filter(number -> number < 0)
                .boxed()
                .map(Object::toString)
                .collect(Collectors.joining(","));
        if(!negatives.isEmpty()) {
            throw new RuntimeException("Negatives not allowed: " + negatives);
        }
    }
}