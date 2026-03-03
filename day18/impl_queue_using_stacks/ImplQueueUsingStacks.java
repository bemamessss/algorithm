package day18.impl_queue_using_stacks;
import java.util.Stack;

public class ImplQueueUsingStacks {

    // 1. 두 개의 스택 선언 (입구용, 출구용)
    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    public ImplQueueUsingStacks() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }
    
    // 2. 데이터 넣기 (Push): 고민 없이 input 스택에 넣는다. -> O(1)
    public void push(int x) {
        inputStack.push(x);
    }
    
    // 3. 데이터 꺼내기 (Pop): output 스택에서 꺼낸다. 
    // 만약 output이 비어있다면, input에 있는 걸 싹 다 옮겨온 뒤 꺼낸다. -> Amortized O(1)
    public int pop() {
        if (outputStack.isEmpty()) {
            this.moveInputToOutput();
        }
        return outputStack.pop();
    }
    
    // 4. 맨 앞 데이터 보기 (Peek): pop과 로직 동일 (삭제만 안 함)
    public int peek() {
        if (outputStack.isEmpty()) {
            this.moveInputToOutput();
        }
        return outputStack.peek();
    }
    
    // 5. 비었는지 확인: 입구와 출구 둘 다 비어야 진짜 빈 것이다.
    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    // [핵심 도우미 함수] input -> output 데이터 이동
    // 주의: peek()만 하면 무한루프에 빠짐! 반드시 pop()으로 꺼내서 옮겨야 함.
    public void moveInputToOutput() {
        while (!inputStack.isEmpty()) {
            outputStack.push(inputStack.pop());
        }
    }
}