package Task_1_1_1;

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
        int[] output = {0, 8, 15, 21, 50};

        HeapSort.sort(input);
        Assertions.assertArrayEquals(input, output);
    }
    @Test
    void NegativeTest(){
        int s = 5;
        int[] input = {-1000, -10, -1, -13, -29};
        int[] output = {-1000, -29, -13, -10, -1};
        HeapSort.sort(input);
        Assertions.assertArrayEquals(input, output);
    }
    @Test
    void PosNegTest(){
        int s = 5;
        int[] input = {0, -10, -1000, 1000, 25};
        int[] output = {-1000, -10, 0, 25, 1000};
        HeapSort.sort(input);
        Assertions.assertArrayEquals(input, output);
    }
    @Test
    void EmptyTest(){
        int s = 0;
        int[] input = {};
        int[] output = {};
        HeapSort.sort(input);
        Assertions.assertArrayEquals(input, output);
    }
    @Test
    void OneElemTest(){
        int s = 1;
        int[] input = {0};
        int[] output = {0};
        HeapSort.sort(input);
        Assertions.assertArrayEquals(input, output);
    }
    @Test
    void OneEqualTest(){
        int s = 5;
        int[] input = {100, 29, -20, 29, 0};
        int[] output = {-20, 0, 29, 29, 100};
        HeapSort.sort(input);
        Assertions.assertArrayEquals(input, output);
    }
    @Test
    void EqualTest(){
        int s = 5;
        int[] input = {13, 13, 13, 13, 13};
        int[] output = {13, 13, 13, 13, 13};
        HeapSort.sort(input);
        Assertions.assertArrayEquals(input, output);
    }
}
