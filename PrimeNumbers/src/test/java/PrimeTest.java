import nsu.oop.spooky.PrimeCheck;
import nsu.oop.spooky.PrimeFind;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PrimeTest {

    @Test
    public void SimpleTest() {
        List<Integer> a = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        StringBuilder answer = new StringBuilder();
        for (Integer i : a)
        {
            if (PrimeCheck.isNotPrime(i)) {
                answer.append("1");
            }
            else {
                answer.append("0");
            }
        }
        Assertions.assertEquals("0001010", (answer.toString()));
    }


    public static List<Integer> createBigArray() {
        Integer[] arr = {6997901, 6997927, 6997937, 6997967, 6998009, 6998029, 6998039, 6998051, 6998053};
        int len = arr.length;
        Integer[] bigArr = new Integer[arr.length*1000];
        int newLen = bigArr.length;
        for (int k = 0; k < newLen; k += len) {
            System.arraycopy(arr, 0, bigArr, k, arr.length);
        }
        return List.of(bigArr);
    }

    private static Stream<Arguments> provideBigArray() {
        return Stream.of(
                Arguments.of(createBigArray())
        );
    }

    @ParameterizedTest
    @MethodSource("provideBigArray")
    public void consequentTest(List<Integer> a) {
        Assertions.assertFalse(PrimeFind.consequentSearch(a));
    }

    @ParameterizedTest
    @MethodSource("provideBigArray")
    public void threadTest(List<Integer> a) throws InterruptedException {
        for (int i = 1; i <= 16; i++) {
            Assertions.assertFalse(PrimeFind.threadSearch(a, i));
        }
    }

    @ParameterizedTest
    @MethodSource("provideBigArray")
    public void parallelTest(List<Integer> a) {
        Assertions.assertFalse(PrimeFind.parallelSearch(a));
    }
}
