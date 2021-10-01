package Task_1_1_1;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Task_1_1_1.HeapSort;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HeapSortTest {
    @Test
    void SimpleTest(){
        int s = 5;
        int[] input = {15, 8, 0, 50, 21};
        int[] output = input;
        Arrays.sort(output);

        HeapSort.sort(input);
        Assertions.assertArrayEquals(input, input);
    }
    @Test
    void NegativeTest(){
        int s = 5;
        int[] input = {-1000, -10, -1, -13, -29};
        int[] output = input;
        Arrays.sort(output);
        HeapSort.sort(input);
        Assertions.assertArrayEquals(input, output);
    }
    @Test
    void PosNegTest(){
        int s = 5;
        int[] input = {0, -10, -1000, 1000, 25};
        int[] output = input;
        Arrays.sort(output);
        HeapSort.sort(input);
        Assertions.assertArrayEquals(input, output);
    }
    @Test
    void EmptyTest(){
        int s = 0;
        int[] input = {};
        int[] output = input;
        Arrays.sort(output);
        HeapSort.sort(input);
        Assertions.assertArrayEquals(input, output);
    }
    @Test
    void OneElemTest(){
        int s = 1;
        int[] input = {0};
        int[] output = input;
        Arrays.sort(output);
        HeapSort.sort(input);
        Assertions.assertArrayEquals(input, output);
    }
    @Test
    void OneEqualTest(){
        int s = 5;
        int[] input = {100, 29, -20, 29, 0};
        int[] output = input;
        Arrays.sort(output);
        HeapSort.sort(input);
        Assertions.assertArrayEquals(input, output);
    }
    @Test
    void EqualTest(){
        int s = 5;
        int[] input = {13, 13, 13, 13, 13};
        int[] output = input;
        Arrays.sort(output);
        HeapSort.sort(input);
        Assertions.assertArrayEquals(input, output);
    }

    @Test
    void NullTest(){
        int s = 0;
        int[] input = null;
        int[] output = null;
        HeapSort.sort(input);
        Assertions.assertArrayEquals(input, output);
    }
}
