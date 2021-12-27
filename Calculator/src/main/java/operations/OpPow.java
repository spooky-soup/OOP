package operations;

import java.util.Stack;

public class OpPow implements Operation{
    @Override
    public int getArgsNumber() {
        return 2;
    }

    @Override
    public void calculate(Stack<Double> stack) {
        stack.push(Math.pow(stack.pop(), stack.pop()));
    }
}
