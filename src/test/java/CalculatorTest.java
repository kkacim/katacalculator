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

    @Test
    public void shouldReturnSumOnMultipleNumbersSeparatedByComma() {
        assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
    public void shouldAcceptNewLineAsValidSeparator() {
        assertEquals(6, Calculator.add("1,2\n3"));
    }

    @Test
    public void shouldAcceptCustomSeparator() {
        assertEquals(3, Calculator.add("//;\n1;2"));
    }

    @Test
    public void shouldAcceptSpecialCharsSeparators() {
        assertEquals(3, Calculator.add("//.\n1.2"));
    }

    @Test
    public void shouldRaiseExceptionOnNegativeInputs() {
        try {
            Calculator.add("-1,2,3");
            fail("Exception should be raised");
        } catch(Exception ex) {
            // ok
        }
    }

    @Test
    public void exceptionMessageShouldContainAllNegativeNumbers() {
        try {
            Calculator.add("-1,2,3,-4");
            fail("Exception should be raised");
        } catch(Exception ex) {
            assertEquals("Negatives not allowed: -1,-4", ex.getMessage());
        }
    }
}