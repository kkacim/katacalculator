public class Calculator {

    private static final String SEPARATOR = ",";

    public static int add(String input) {
        if(input==null || input.isEmpty()) {
            return 0;
        }
        else if(input.contains(SEPARATOR)) {
            String[] numbers = input.split(SEPARATOR);
            return Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
        }
        return Integer.parseInt(input);
    }
}