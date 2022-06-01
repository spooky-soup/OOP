package operations;

import java.util.Stack;

public class OpSin implements Operation{
    @Override
    public int getArgsNumber() {
        return 1;
    }

    @Override
    public void calculate(Stack<Double> stack) {
        stack.push(Math.sin(stack.pop()));
    }
}
