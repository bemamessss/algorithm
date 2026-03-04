package day19.min_stack;

import java.util.*;

public class MinStack {

    // stack 대신 deque 사용
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);

        // 같거나 더 작을 때만 넣는다.
        if( minStack.isEmpty() || val <= minStack.peek() ) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        // 그냥 빼면 integer니까 오토 언박싱. 안 하면 equals로 비교해야 함.
        int val = stack.pop();
        if( val == minStack.peek() ) {
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */