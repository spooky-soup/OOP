import nsu.fit.oop.task_1_2_1.MyStack;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyStackTest {
    public static Stream<Arguments> myTests() {
        ArrayList<Integer> simpleTest = new ArrayList<>(List.of(34, 55, 20, 134, 0));
        return Stream.of(Arguments.of(simpleTest));
    }


    @ParameterizedTest
    @MethodSource("myTests")
    public void testing(ArrayList<Integer> input) {
        MyStack<Integer> output = new MyStack<>();
        for (Integer var : input) {
            output.push(var);
        }
        assertEquals(output.count(), input.size());

    }
}

