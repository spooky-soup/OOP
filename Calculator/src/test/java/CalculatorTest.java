import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    public void simpleTest() {
        Double res = Calculator.calculate("sin + - 1 2 1");
        System.out.println(res);
    }
}
