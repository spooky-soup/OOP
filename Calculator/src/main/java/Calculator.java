import operations.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Calculator {
    static Map<String, Operation> myOperations = new HashMap<>(){
        {
            put ("+", new OpAdd());
            put ("-", new OpSub());
            put ("*", new OpMlt());
            put ("/", new OpDiv());
            put("sin", new OpSin());
            put("cos", new OpCos());
            put ("sqrt", new OpSqrt());
            put ("log", new OpLog());
            put ("ln", new OpLog());
            put ("pow", new OpPow());
        }};

    public static Operation operationFromString(String operationName) {
        if(!myOperations.containsKey(operationName)) throw new IllegalArgumentException("No such operation: " + operationName);
        return(myOperations.get(operationName));
    }

    public static Double calculate(String expression) {
        String[] tokens = expression.split(" ");
        Stack<Double> stack = new Stack<>();
        int size = tokens.length;
        for (int i = size - 1; i >= 0; i--) {
            if (isNumber(tokens[i])) stack.push(Double.parseDouble(tokens[i]));
            else {
                Operation currOp = operationFromString(tokens[i]);
                if (stack.size() < currOp.getArgsNumber()) throw new IllegalArgumentException("Not enough arguments");
                else currOp.calculate(stack);
            }
        }
        return stack.pop();
    }

    public static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
