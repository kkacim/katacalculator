import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    public void shouldReturnZeroOnNull() {
        assertEquals(0, Calculator.add(null));
    }

    @Test
    public void shouldReturnZeroOnEmptyString() {
        assertEquals(0, Calculator.add(""));
    }

    @Test
    public void shouldReturnNumberOnNumber() {
        assertEquals(1, Calculator.add("1"));
    }

    @Test
    public void shouldReturnSumOn2NumbersSeparatedByComma() {
        assertEquals(3, Calculator.add("1,2"));
    }
}
