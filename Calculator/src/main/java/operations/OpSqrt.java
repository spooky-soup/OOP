package operations;

import java.util.Stack;

public class OpSqrt implements Operation{
    @Override
    public int getArgsNumber() {
        return 1;
    }

    @Override
    public void calculate(Stack<Double> stack) {
        stack.push(Math.sqrt(stack.pop()));
    }
}
