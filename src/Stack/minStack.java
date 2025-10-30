package Stack;

import java.util.Stack;

public class minStack {
    Stack<Integer> stack;
    Stack<Integer> min_stack;

    public minStack() {
        stack = new Stack<>();
        min_stack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        if (min_stack.isEmpty() || val <= min_stack.peek()) {
            min_stack.push(val);
        }

    }

    public void pop() {
        int popped = stack.pop();
        if (popped == min_stack.peek()) {
            min_stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }
    public static void main(String[] args) {
        minStack st = new minStack();
        st.push(5);
        st.push(3);
        st.push(7);
        System.out.println("Current Min: " + st.getMin()); // 3
        st.pop();
        System.out.println("Top: " + st.top()); // 3
        System.out.println("Current Min: " + st.getMin()); // 3
        st.pop();
        System.out.println("Current Min: " + st.getMin()); // 5
    }
}