package Task_1_1_1;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import Task_1_1_1.HeapSort;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.*;

public class HeapSortTest {

    static ArrayList<int[]> testData() {
        var list = new ArrayList<int[]>();

        list.add(new int[] {15, 8, 0, 50, 21}); //simple test
        list.add(new int[] {0, 0, 0, 0, 0}); //zeros + same values
        list.add(new int[] {-1000, -10, -1, -13, -29}); //negative
        list.add(new int[] {0, -10, -1000, 1000, 25}); //pos + neg
        list.add(new int[] {}); //empty
        list.add(new int[] {0}); //1 value
        list.add(new int[] {100, 29, -20, 29, 0}); //2 same values
        list.add(new int[] {13, 13, 13, 13, 13}); //all the same
        list.add(new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE});

        return list;
    }
    @ParameterizedTest
    @MethodSource("testData")
    public static void testsHeapSort(int[] input) {
        int[] output = input.clone();
        Arrays.sort(output);
        HeapSort.sort(input);
        assertArrayEquals(output, input);
    }

    @ParameterizedTest
    @NullSource
    public static void nullTest(int[] input) {
        assertThrows(IllegalArgumentException.class, ()->HeapSort.sort(input));
    }

}
