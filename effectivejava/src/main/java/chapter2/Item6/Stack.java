package chapter2.Item6;// Can you spot the "memory leak"?

import java.util.*;

public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object res = elements[--size];
        elements[size] = null;//you should do this to avoid memeory leak
        return res;
    }

    /**
     * Ensure space for at least one more element, roughly
     * doubling the capacity each time the array needs to grow.
     */
    private void ensureCapacity() {
        if(elements.length > Integer.MAX_VALUE){
            throw new IllegalArgumentException("the stack has reached the max length;");
        }
        int newLen = 2 * size + 1;
        if (elements.length == size){
            if (newLen > Integer.MAX_VALUE) {
                newLen = Integer.MAX_VALUE;
            }
            elements = Arrays.copyOf(elements, newLen);
        }

    }
}
