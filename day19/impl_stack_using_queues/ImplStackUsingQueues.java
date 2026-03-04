package day19.impl_stack_using_queues;

import java.util.*;

public class ImplStackUsingQueues {

    private Queue<Integer> q;

    public ImplStackUsingQueues() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        // 일단 뒤로 넣고, 제일 앞에 오도록 앞에 있는 애들을 다시 꺼내서 뒤로 넣음.
        q.offer( x );
        for( int i = 0 ; i < q.size() - 1 ; i ++ ) {
            q.offer( q.poll() );
        }
    }
    
    public int pop() {
        // 넣을 때 이미 정렬됐으니까 그냥 꺼내면 됨.
        return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */