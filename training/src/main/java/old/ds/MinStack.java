package old.ds;

import java.util.ArrayDeque;

public class MinStack {
    private ArrayDeque<Integer> stack;
    private ArrayDeque<Integer> minStack;

    MinStack() {
        this.stack = new ArrayDeque<>();
        this.minStack = new ArrayDeque<>();
    }

    public void push(int number) {
        stack.push(number);
        if (minStack.isEmpty()) {
            minStack.push(number);
        } else {
            // 实现最大栈时，只需push(Math.max(number, minStack.peek())
            minStack.push(Math.min(number, minStack.peek()));
        }
    }

    public int pop() {
        minStack.pop();
        return stack.pop();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack=new MinStack();
        minStack.push(3);
        minStack.push(4);
        minStack.push(5);
        minStack.push(6);

        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
    }
}
