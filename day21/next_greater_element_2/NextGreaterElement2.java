package day21.next_greater_element_2;
import java.util.*;

public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Deque<Integer> stack = new ArrayDeque<>();

        for( int i = 0 ; i < n * 2 ; i ++ ) {
            int index = i % n;

            // 인덱스를 저장했으니까 nums[stack.peek()]다. 인덱스 안에 든 실제 수끼리 비교해야 함.
            while( !stack.isEmpty() && nums[stack.peek()] < nums[index] ) {
                // 해당하는 인덱스에 더 큰수로 덮어쓰기.
                result[stack.pop()] = nums[index];
            }

            // 첫 턴에서만 짝 없는 스택에 넣어 준다. 두 번째 턴은 이미 있는 스택에서 짝 찾기만 할 것이므로.
            // e.g. 길이(n)가 3이면 0,1,2까지가 한 바퀴다. 3이 되는 순간 두 바퀴므로 i <= n은 안 됨.
            if( i < n ) {
                stack.push(index);
            }
        }

        return result;
    }
}