package operations;

import java.util.Stack;

public class OpDiv implements Operation{
    @Override
    public int getArgsNumber() {
        return 2;
    }

    @Override
    public void calculate(Stack<Double> stack) {
        stack.push(stack.pop() / stack.pop());
    }
}
