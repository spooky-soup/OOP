import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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



    @Test
    public void consequentTest() {
        List<Integer> a = Arrays.asList(6997901, 6997927, 6997937, 6997967, 6998009, 6998029, 6998039, 6998051, 6998053);
        Assertions.assertFalse(PrimeFind.consequentSearch(a));
    }

    @Test
    public void threadTest() {
        List<Integer> a = Arrays.asList(6997901, 6997927, 6997937, 6997967, 6998009, 6998029, 6998039, 6998051, 6998053);
        Assertions.assertFalse(PrimeFind.threadSearch(a, 4));
    }

    @Test
    public void parallelTest() {
        List<Integer> a = Arrays.asList(6997901, 6997927, 6997937, 6997967, 6998009, 6998029, 6998039, 6998051, 6998053);
        Assertions.assertFalse(PrimeFind.parallelSearch(a));
    }
}
