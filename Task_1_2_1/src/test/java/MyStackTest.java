import nsu.fit.oop.task_1_2_1.MyStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static nsu.fit.oop.task_1_2_1.MyStack.createStackFromArray;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MyStackTest {
    public static Stream<Arguments> myNumericTests() {
        ArrayList<Integer> simpleTest = new ArrayList<>(List.of(34, 55, -20, 134, 0));
        ArrayList<Integer> bigTest = new ArrayList<>(List.of(34, Integer.MAX_VALUE, 20, Integer.MIN_VALUE, 0, 1, 2, 3));
        ArrayList<Integer> onlyElemTest = new ArrayList<>(List.of(1));
        return Stream.of(Arguments.of(simpleTest), Arguments.of(bigTest), Arguments.of(onlyElemTest));
    }

    public static Stream<Arguments> myStringTests() {
        ArrayList<String> simpleStringTest = new ArrayList<>(List.of("a", "b", "c", "d", "Hello", "World"));
        ArrayList<String> onlyStringTest = new ArrayList<>(List.of(""));
        return Stream.of(Arguments.of(simpleStringTest), Arguments.of(onlyStringTest));
    }

    public static Stream<Arguments> emptyTests() {
        ArrayList<Integer> emptyNumericTest = new ArrayList<>(List.of());
        ArrayList<String> emptyStringTest = new ArrayList<>(List.of());
        return Stream.of(Arguments.of(emptyNumericTest), Arguments.of(emptyStringTest));
    }

    @ParameterizedTest
    @MethodSource("myNumericTests")
    public void pushTesting(ArrayList<Integer> input) {
        MyStack<Integer> output = new MyStack<>();
        for (Integer elem : input) {
            output.push(elem);
        }
        assertEquals(output.count(), input.size());
    }

    @ParameterizedTest
    @MethodSource("myStringTests")
    public void stringPushTesting(ArrayList<String> input) {
        MyStack<String> output = new MyStack<>();
        for (String elem : input) {
            output.push(elem);
        }
        assertEquals(output.count(), input.size());
        assertEquals(output.pop(), input.get(input.size() - 1));
    }

    @ParameterizedTest
    @MethodSource("myNumericTests")
    public void popTesting(ArrayList<Integer> input) {
        MyStack<Integer> stack = createStackFromArray(input);
        for (int i = input.size() - 1; i >= 0; i--) {
            assertEquals(stack.pop(), input.get(i));
        }
    }

    @ParameterizedTest
    @MethodSource("myNumericTests")
    public void emptyPopTest(ArrayList<Integer> input) {
        input.clear();
        MyStack<Integer> stack = createStackFromArray(input);
        Assertions.assertThrows(IndexOutOfBoundsException.class, stack::pop);
    }
}

