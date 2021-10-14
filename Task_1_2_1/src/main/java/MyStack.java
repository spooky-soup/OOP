package nsu.fit.oop.task_1_2_1;

import java.util.Arrays;

public class MyStack<T>{
    private T[] stackArray = (T[])new Object[10];
    private int size = 10;
    private int last = -1;

    /*public MyStack() {
        this.size = size;
        stackArray = (T[]) new Object[size];
        last = -1;
    }*/

    private boolean isEmpty() {
        return last == -1;
    }
    public int count() {
        return last+1;
    }

    public void push(T var) {
        if (this.last >= size-1)
        {
            size = 2*size;
            stackArray = Arrays.copyOf(stackArray, size);
        }
        stackArray[++last] = var;
    }

    public T pop() throws IndexOutOfBoundsException {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        else {
            T elem = stackArray[last];
            stackArray[last--] = null;
            return elem;
        }
    }

    public void pushStack(MyStack<T> s) {
        int len = s.last+1;
        T[] insert = (T[])new Object[len];
        for (int i = 0; i <= s.last; i++) {
            insert[i] = s.pop();
        }
        for (int i = len - 1; i >= 0; i--) {
            this.push(insert[i]);
        }
    }

    public MyStack<T> popStack(int n)
    {
        MyStack<T> res = new MyStack<>();
        T[] insert = (T[])new Object[this.last + 1];
        for (int i = 0; i < n; i++) {
            insert[i] = this.pop();
        }
        for (int i = n - 1; i >= 0; i--) {
            res.push(insert[i]);
        }
        return res;
    }

}