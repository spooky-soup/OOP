import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FinderTesting {

    @Test
    void russianWordTest() {
        int[] rightRes = {22, 31};
        int [] realRes = SubstringFinder.findSubstring("test.txt", "тест");
        Assertions.assertArrayEquals(realRes, rightRes);
    }

    @Test
    void englishWordTest() {
        int[] rightRes = {8, 13};
        int [] realRes = SubstringFinder.findSubstring("test.txt", "test");
        Assertions.assertArrayEquals(realRes, rightRes);
    }

    @Test
    void multilineTest() {
        int[] rightRes = {14};
        int [] realRes = SubstringFinder.findSubstring("test.txt", "est\nэто ");
        Assertions.assertArrayEquals(realRes, rightRes);
    }

    @Test
    void noSuchStringTest() {
        int[] rightRes = {};
        int [] realRes = SubstringFinder.findSubstring("test.txt", "no such string");
        Assertions.assertArrayEquals(realRes, rightRes);
    }
}
