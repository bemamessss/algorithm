import java.util.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        Set<Integer> set = new HashSet<>(nums.length);

        for( int i = 0 ; i < nums.length ; i ++ ) {

            // k+1 크기로 만들어 놓고 그 안에 중복이 있으면 조건 만족.
            if( !set.add(nums[i]) ) {
                return true;
            }  

            // 사이즈 초과하면 앞부터 지워 버린다. => 미리 지워야 함!! 앞에서 바로 넣으니까.
            if( set.size() > k ) {
                // 순서 보장이 안 되니 인덱스 개념이 없음!! 값을 지정해서 지워야 한다. i-k가 제일 앞인 걸 잘 이해하자.
                set.remove( nums[i - k] );
            }
        }

        return false;
    }
}