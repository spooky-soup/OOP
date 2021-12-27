package operations;

import java.util.Stack;

public interface Operation {
    int getArgsNumber();
    void calculate(Stack<Double> stack);
}
